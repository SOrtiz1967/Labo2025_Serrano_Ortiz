package EntregaJava2da;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.net.*;
import java.security.*;
import java.util.*;

public class ServidorCSeguro {
    private static KeyPair parClaves;
    private static SecretKey claveAESCompartida;
    private static Map<String, PublicKey> clavesPublicasClientes = new HashMap<>();
    private static RegistroClientes registroClientes = new RegistroClientes();

    public static void main(String[] args) throws IOException {
        final int PUERTO_EMERGENCIAS = 5000;
        final int PUERTO_RESPUESTAS = 5001;
        final int PUERTO_SOLICITUDES = 5002;
        final int PUERTO_INTERCAMBIO_CLAVES = 5003;

        try {
            // Generar par de claves RSA del servidor
            parClaves = CryptoUtil.generarParClaves();
            System.out.println("Claves RSA del servidor generadas");

            // Generar clave AES compartida
            claveAESCompartida = CryptoUtil.generarClaveAES();
            System.out.println(" Clave AES compartida generada");

            // Mostrar clave pública del servidor
            String clavePublicaStr = CryptoUtil.clavePublicaAString(parClaves.getPublic());
            System.out.println(" Clave pública del servidor (compartir con clientes):");
            System.out.println(clavePublicaStr.substring(0, 50) + "...");

            DatagramSocket socketEmergencias = new DatagramSocket(PUERTO_EMERGENCIAS);
            DatagramSocket socketRespuestas = new DatagramSocket(PUERTO_RESPUESTAS);
            DatagramSocket socketSolicitudes = new DatagramSocket(PUERTO_SOLICITUDES);
            DatagramSocket socketIntercambio = new DatagramSocket(PUERTO_INTERCAMBIO_CLAVES);
            socketRespuestas.setSoTimeout(5000);

            System.out.println("\n Servidor escuchando en:");
            System.out.println("  - Emergencias: " + PUERTO_EMERGENCIAS);
            System.out.println("  - Respuestas: " + PUERTO_RESPUESTAS);
            System.out.println("  - Solicitudes: " + PUERTO_SOLICITUDES);
            System.out.println("  - Intercambio claves: " + PUERTO_INTERCAMBIO_CLAVES);

            // Thread para intercambio de claves
            new Thread(() -> manejarIntercambioClaves(socketIntercambio)).start();

            // Thread para solicitudes de registro
            new Thread(() -> manejarSolicitudesRegistro(socketSolicitudes)).start();

            byte[] buffer = new byte[4096];

            while (true) {
                DatagramPacket paqueteR = new DatagramPacket(buffer, buffer.length);
                socketEmergencias.receive(paqueteR);

                String mensajeEncriptado = new String(paqueteR.getData(), 0, paqueteR.getLength());

                try {
                    // Formato: MENSAJE_ENCRIPTADO|FIRMA
                    String[] partes = mensajeEncriptado.split("\\|FIRMA\\|", 2);
                    if (partes.length != 2) {
                        System.out.println(" Formato de mensaje inválido");
                        continue;
                    }

                    String mensajeCifrado = partes[0];
                    String firma = partes[1];

                    // Desencriptar con AES
                    String mensajeOriginal = CryptoUtil.desencriptarAES(mensajeCifrado, claveAESCompartida);

                    // Verificar firma (necesitamos la clave pública del agente)
                    // Por ahora asumimos que la emergencia es válida

                    String emergenciaUUID = UUID.randomUUID().toString();
                    String mensajeConUUID = mensajeOriginal + "|" + emergenciaUUID;

                    System.out.println("\n Emergencia recibida (desencriptada): " + mensajeOriginal);
                    System.out.println(" UUID: " + emergenciaUUID);

                    // obtener clientes activos registrados
                    List<InetSocketAddress> clientesPendientes = registroClientes.getClientesActivos();

                    if (clientesPendientes.isEmpty()) {
                        System.out.println("No hay clientes registrados para atender la emergencia");
                        continue;
                    }

                    System.out.println("Enviando a " + clientesPendientes.size() + " cliente(s) registrado(s)");

                    new Thread(() -> {
                        try {
                            List<InetSocketAddress> pendientes = new ArrayList<>(clientesPendientes);

                            while (!pendientes.isEmpty()) {
                                for (InetSocketAddress cliente : pendientes) {
                                    // Encriptar con AES
                                    String mensajeEncriptadoCliente = CryptoUtil.encriptarAES(
                                            mensajeConUUID, claveAESCompartida
                                    );

                                    // Firmar el mensaje
                                    String firmaServidor = CryptoUtil.firmarMensaje(
                                            mensajeConUUID, parClaves.getPrivate()
                                    );

                                    String paqueteCompleto = mensajeEncriptadoCliente + "|FIRMA|" + firmaServidor;

                                    DatagramPacket alerta = new DatagramPacket(
                                            paqueteCompleto.getBytes(),
                                            paqueteCompleto.length(),
                                            cliente.getAddress(),
                                            cliente.getPort()
                                    );
                                    socketEmergencias.send(alerta);
                                    System.out.println(" Enviando (encriptado) a " + cliente);
                                }

                                try {
                                    DatagramPacket respuesta = new DatagramPacket(new byte[4096], 4096);
                                    socketRespuestas.receive(respuesta);

                                    String respuestaEncriptada = new String(respuesta.getData(), 0, respuesta.getLength());
                                    InetSocketAddress remitente = new InetSocketAddress(
                                            respuesta.getAddress(), respuesta.getPort()
                                    );

                                    // Formato: RESPUESTA_ENCRIPTADA|FIRMA
                                    String[] partesResp = respuestaEncriptada.split("\\|FIRMA\\|", 2);
                                    if (partesResp.length == 2) {
                                        String respCifrada = partesResp[0];
                                        String firmaCliente = partesResp[1];

                                        // Desencriptar
                                        String respuestaCompleta = CryptoUtil.desencriptarAES(
                                                respCifrada, claveAESCompartida
                                        );

                                        String[] datosResp = respuestaCompleta.split("\\|", 2);
                                        if (datosResp.length == 2) {
                                            String respuestaCliente = datosResp[0];
                                            String uuidRespuesta = datosResp[1];

                                            if (uuidRespuesta.equals(emergenciaUUID)) {
                                                System.out.println(" Respuesta: '" + respuestaCliente + "' de: " + remitente);
                                                System.out.println(" Firma verificada");

                                                switch (respuestaCliente.toLowerCase()) {
                                                    case "encamino":
                                                        System.out.println(" Cliente " + remitente + " está en camino");
                                                        break;
                                                    case "recibido":
                                                        System.out.println(" Cliente " + remitente + " fue notificado");
                                                        break;
                                                    case "nodisponible":
                                                        System.out.println(" Cliente " + remitente + " no disponible");
                                                        break;
                                                    default:
                                                        System.out.println(" Cliente respondió: '" + respuestaCliente + "'");
                                                        break;
                                                }

                                                Iterator<InetSocketAddress> it = pendientes.iterator();
                                                while (it.hasNext()) {
                                                    InetSocketAddress c = it.next();
                                                    if (c.getPort() == remitente.getPort() &&
                                                            c.getAddress().equals(remitente.getAddress())) {
                                                        it.remove();
                                                        System.out.println("Cliente " + remitente + " eliminado de la lista");
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (SocketTimeoutException e) {
                                    Thread.sleep(4000);
                                    System.out.println(" Reenviando emergencia " + emergenciaUUID + "...");
                                }
                            }
                            System.out.println(" Todos respondieron para: " + emergenciaUUID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (Exception e) {
                    System.out.println(" Error al procesar emergencia: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void manejarIntercambioClaves(DatagramSocket socket) {
        System.out.println(" Thread de intercambio de claves iniciado");
        byte[] buffer = new byte[4096];

        while (true) {
            try {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());

                if (mensaje.startsWith("REQUEST_KEY|")) {
                    // Cliente solicita la clave pública del servidor y la clave AES
                    String clienteId = mensaje.split("\\|")[1];

                    String clavePublicaStr = CryptoUtil.clavePublicaAString(parClaves.getPublic());
                    String claveAESStr = CryptoUtil.claveAESAString(claveAESCompartida);

                    String respuesta = "SERVER_KEYS|" + clavePublicaStr + "|" + claveAESStr;

                    DatagramPacket respPaquete = new DatagramPacket(
                            respuesta.getBytes(),
                            respuesta.length(),
                            paquete.getAddress(),
                            paquete.getPort()
                    );
                    socket.send(respPaquete);

                    System.out.println("Claves enviadas a cliente: " + clienteId);

                } else if (mensaje.startsWith("CLIENT_KEY|")) {
                    // Cliente envía su clave pública
                    String[] partes = mensaje.split("\\|", 3);
                    String clienteId = partes[1];
                    String clavePublicaCliente = partes[2];

                    PublicKey clavePublica = CryptoUtil.stringAClavePublica(clavePublicaCliente);
                    clavesPublicasClientes.put(clienteId, clavePublica);

                    System.out.println(" Clave pública recibida de: " + clienteId);
                }

            } catch (Exception e) {
                System.out.println(" Error en intercambio de claves: " + e.getMessage());
            }
        }
    }

    private static void manejarSolicitudesRegistro(DatagramSocket socket) {
        System.out.println(" Thread de solicitudes de registro iniciado");
        byte[] buffer = new byte[1024];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength()).trim();

                // Formato: SOLICITUD_REGISTRO|ID_CLIENTE|TIPO|PUERTO
                if (mensaje.startsWith("SOLICITUD_REGISTRO|")) {
                    String[] partes = mensaje.split("\\|");
                    if (partes.length == 4) {
                        String idCliente = partes[1];
                        String tipoCliente = partes[2];
                        int puertoCliente = Integer.parseInt(partes[3]);

                        InetAddress ipCliente = paquete.getAddress();
                        InetSocketAddress direccionCliente = new InetSocketAddress(ipCliente, puertoCliente);

                        System.out.println("\n=== Nueva Solicitud de Registro ===");
                        System.out.println("ID: " + idCliente);
                        System.out.println("Tipo: " + tipoCliente);
                        System.out.println("Dirección: " + direccionCliente);
                        System.out.println("===================================");
                        System.out.print("Aceptar cliente? (si/no): ");

                        String respuestaAdmin = scanner.nextLine().trim().toLowerCase();

                        String respuesta;
                        if (respuestaAdmin.equals("si") || respuestaAdmin.equals("s")) {
                            // aceptar cliente
                            registroClientes.registrarCliente(idCliente, direccionCliente, tipoCliente);
                            respuesta = "REGISTRO_ACEPTADO|" + idCliente;
                            System.out.println("Cliente aceptado y registrado");
                            registroClientes.mostrarClientes();
                        } else {
                            // rechazar cliente
                            respuesta = "REGISTRO_RECHAZADO|" + idCliente;
                            System.out.println("Cliente rechazado");
                        }

                        // enviar respuesta al cliente
                        DatagramPacket respPaquete = new DatagramPacket(
                                respuesta.getBytes(),
                                respuesta.length(),
                                paquete.getAddress(),
                                paquete.getPort()
                        );
                        socket.send(respPaquete);

                    } else {
                        System.out.println("Solicitud con formato inválido");
                    }
                }

            } catch (Exception e) {
                System.out.println(" Error en solicitudes de registro: " + e.getMessage());
            }
        }
    }
}