package EntregaJava2da;

import javax.crypto.SecretKey;
import java.net.*;
import java.security.*;
import java.util.*;

public class ClienteRSeguro {
    private static KeyPair parClaves;
    private static PublicKey clavePublicaServidor;
    private static SecretKey claveAESCompartida;

    public static void main(String[] args) {
        int PUERTO_CLIENTE = 6000;

        if (args.length > 0) {
            try {
                PUERTO_CLIENTE = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("puerto inválido(6000).");
            }
        }

        final String IP_SERVIDOR = "172.16.4.176";
        final int PUERTO_RESPUESTAS = 5001;
        final int PUERTO_INTERCAMBIO = 5003;

        try {
            // Generar par de claves RSA del cliente
            parClaves = CryptoUtil.generarParClaves();
            System.out.println("🔐 Claves RSA del cliente generadas");

            // Obtener claves del servidor intercambiar
            DatagramSocket socketIntercambio = new DatagramSocket();

            String clienteId = "CLIENTE_" + PUERTO_CLIENTE;
            String solicitud = "REQUEST_KEY|" + clienteId;
            DatagramPacket paqueteSolicitud = new DatagramPacket(
                    solicitud.getBytes(),
                    solicitud.length(),
                    InetAddress.getByName(IP_SERVIDOR),
                    PUERTO_INTERCAMBIO
            );
            socketIntercambio.send(paqueteSolicitud);
            System.out.println("🔄 Solicitando claves al servidor");

            byte[] bufferIntercambio = new byte[8192];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferIntercambio, bufferIntercambio.length);
            socketIntercambio.setSoTimeout(5000);
            try {
                socketIntercambio.receive(paqueteRespuesta);
                String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength()).trim();

                if (respuesta.startsWith("SERVER_KEYS|")) {
                    String[] partes = respuesta.split("\\|", 3);
                    if (partes.length == 3) {
                        String clavePublicaStr = partes[1];
                        String claveAESStr = partes[2];

                        clavePublicaServidor = CryptoUtil.stringAClavePublica(clavePublicaStr);
                        claveAESCompartida = CryptoUtil.stringAClaveAES(claveAESStr);

                        System.out.println("Claves del servidor recibidas");
                        System.out.println("Clave AES compartida obtenida");
                    } else {
                        System.out.println("Respuesta SERVER_KEYS con formato incorrecto.");
                    }
                } else {
                    System.out.println(" Respuesta inesperada del servidor en intercambio: " + respuesta);
                }
            } catch (SocketTimeoutException e) {
                System.out.println(" Tiempo de espera agotado al solicitar claves al servidor.");
            } finally {
                socketIntercambio.close();
            }

            // Si no obtuvimos claves, no podemos continuar
            if (clavePublicaServidor == null || claveAESCompartida == null) {
                System.out.println(" No se obtuvieron las claves necesarias. hay algun problema");
                return;
            }

            // Enviar clave pública del cliente al servidor
            String clavePublicaClienteStr = CryptoUtil.clavePublicaAString(parClaves.getPublic());
            String mensajeClavePublica = "CLIENT_KEY|" + clienteId + "|" + clavePublicaClienteStr;

            DatagramSocket socketEnvioClave = new DatagramSocket();
            DatagramPacket paqueteClavePublica = new DatagramPacket(
                    mensajeClavePublica.getBytes(),
                    mensajeClavePublica.length(),
                    InetAddress.getByName(IP_SERVIDOR),
                    PUERTO_INTERCAMBIO
            );
            socketEnvioClave.send(paqueteClavePublica);
            socketEnvioClave.close();
            System.out.println(" Clave pública del cliente enviada al servidor");

            System.out.println("\nCliente escuchando en puerto: " + PUERTO_CLIENTE);
            System.out.println(" Mensajes encriptados activados");


            DatagramSocket socket = new DatagramSocket(PUERTO_CLIENTE);
            Scanner scanner = new Scanner(System.in);

            Set<String> uuidsRespondidos = new HashSet<>();

            while (true) {
                // Crear buffer nuevo para cada recepción (evita restos de datos anteriores)
                byte[] buffer = new byte[8192];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensajeRecibido = new String(paquete.getData(), 0, paquete.getLength()).trim();

                try {
                    // Formato esperado: MENSAJE_ENCRIPTADO|FIRMA|
                    String[] partes = mensajeRecibido.split("\\|FIRMA\\|", 2);
                    if (partes.length != 2) {
                        System.out.println("Formato de mensaje inválido recibido desde " +
                                paquete.getAddress() + ":" + paquete.getPort());
                        continue;
                    }

                    String mensajeCifrado = partes[0];
                    String firmaServidor = partes[1];

                    // Desencriptar con AES
                    String mensajeCompleto = CryptoUtil.desencriptarAES(mensajeCifrado, claveAESCompartida);

                    // Verificar firma del servidor
                    boolean firmaValida = CryptoUtil.verificarFirma(
                            mensajeCompleto, firmaServidor, clavePublicaServidor
                    );

                    if (!firmaValida) {
                        System.out.println("Firma inválida mensaje rechazado por posible intercepcion del sombrio interceptor");
                        continue;
                    }

                    // Parsear "emergencia|uuid"
                    String[] datosEmergencia = mensajeCompleto.split("\\|", 2);
                    if (datosEmergencia.length != 2) {
                        System.out.println(" Formato de emergencia inválido: " + mensajeCompleto);
                        continue;
                    }

                    String emergencia = datosEmergencia[0];
                    String uuid = datosEmergencia[1];

                    if (uuidsRespondidos.contains(uuid)) {
                        System.out.println("Emergencia duplicada ignorada (UUID: " + uuid + ")");
                        continue;
                    }

                    System.out.println("\n Emergencia recibida y desencriptada: " + emergencia);
                    System.out.println(" UUID: " + uuid);
                    System.out.println("Firma del servidor verificada, todo en orden");

                    System.out.print("Ingresa respuesta: ");
                    String respuestaUsuario = scanner.nextLine().trim();

                    String respuestaCliente = respuestaUsuario.isEmpty() ? "RECIBIDO" : respuestaUsuario;
                    String respuestaConUUID = respuestaCliente + "|" + uuid;

                    // Encriptar respuesta con AES
                    String respuestaEncriptada = CryptoUtil.encriptarAES(
                            respuestaConUUID, claveAESCompartida
                    );

                    // Firmar la respuesta (firmamos el texto en claro)
                    String firmaCliente = CryptoUtil.firmarMensaje(respuestaConUUID, parClaves.getPrivate());

                    // Formato: RESPUESTA_ENCRIPTADA|FIRMA|
                    String mensajeRespuesta = respuestaEncriptada + "|FIRMA|" + firmaCliente;

                    DatagramPacket respuesta = new DatagramPacket(
                            mensajeRespuesta.getBytes(),
                            mensajeRespuesta.length(),
                            InetAddress.getByName(IP_SERVIDOR),
                            PUERTO_RESPUESTAS
                    );
                    socket.send(respuesta);

                    // Agregar UUID a respondidos
                    uuidsRespondidos.add(uuid);

                    System.out.println("Emergencia procesada y enviada (encriptada + firmada)");
                    System.out.println("Longitud del paquete: " + mensajeRespuesta.getBytes().length + " bytes");
                    System.out.println("Listo para procesar más emergencias\n");

                } catch (Exception e) {
                    System.out.println(" Error al procesar emergencia: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(" Error general en cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
