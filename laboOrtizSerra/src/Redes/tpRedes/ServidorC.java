package Redes.tpRedes;

import Redes.MiRunnable;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ServidorC {
    public static void main(String[] args) throws IOException {
        final int PUERTO_EMERGENCIAS = 5000;
        final int PUERTO_RESPUESTAS = 5001;
        final int PUERTO_SOLICITUDES = 5002;

        try {
            // ✅ Crear sockets una sola vez
            DatagramSocket socketEmergencias = new DatagramSocket(PUERTO_EMERGENCIAS);
            DatagramSocket socketRespuestas = new DatagramSocket(PUERTO_RESPUESTAS);
            DatagramSocket socketSolicitudes = new DatagramSocket(PUERTO_SOLICITUDES);
            socketRespuestas.setSoTimeout(5000);

            System.out.println("escuchando emergencias en puerto " + PUERTO_EMERGENCIAS);
            System.out.println("escuchando respuestas en puerto " + PUERTO_RESPUESTAS);
            System.out.println("escuchando solicitudes de cliente en puerto: " + PUERTO_SOLICITUDES);

            byte[] buffer = new byte[1024];

            while (true) {
                // ✅ Usamos el socket ya creado, no uno nuevo
                DatagramPacket paqueteR = new DatagramPacket(buffer, buffer.length);
                socketEmergencias.receive(paqueteR);

                String mensajeOriginal = new String(paqueteR.getData(), 0, paqueteR.getLength());

                // Generamos un UUID único para la emergencia
                String emergenciaUUID = UUID.randomUUID().toString();
                String mensajeConUUID = mensajeOriginal + "|" + emergenciaUUID;

                System.out.println("Emergencia recibida del agente: " + mensajeOriginal);
                System.out.println("mensaje con el id: " + emergenciaUUID);

                /*
                //para manejar distinto al incendio
                if (mensajeOriginal.equalsIgnoreCase("incendio")) {
                    MiRunnable miRunnable = new MiRunnable("Hilo abierto como .....");
                    new Thread(miRunnable).start();
                }
                */

                // ✅ Ya no usamos un if con receive (porque es void)
                DatagramPacket solicitud = new DatagramPacket(new byte[1024], 1024);
                // Esperar solicitudes (si querés usarlo)
                // socketSolicitudes.receive(solicitud);

                // Lista de clientes pendientes
                List<InetSocketAddress> clientesPendientes = new ArrayList<>();
                clientesPendientes.add(new InetSocketAddress("172.16.4.176", 6000));
                clientesPendientes.add(new InetSocketAddress("172.16.1.92", 6001));
                // clientesPendientes.add(new InetSocketAddress("localhost", 6002));

                new Thread(() -> {
                    try {
                        // Reenvío
                        while (!clientesPendientes.isEmpty()) {
                            for (InetSocketAddress cliente : clientesPendientes) {
                                DatagramPacket alerta = new DatagramPacket(
                                        mensajeConUUID.getBytes(),
                                        mensajeConUUID.length(),
                                        cliente.getAddress(),
                                        cliente.getPort()
                                );
                                socketEmergencias.send(alerta);
                                System.out.println("mandando a " + cliente + ":" + mensajeConUUID);
                            }

                            try {
                                DatagramPacket respuesta = new DatagramPacket(new byte[1024], 1024);
                                socketRespuestas.receive(respuesta);

                                String respuestaCompleta = new String(respuesta.getData(), 0, respuesta.getLength());
                                InetSocketAddress remitente = new InetSocketAddress(respuesta.getAddress(), respuesta.getPort());

                                String[] partes = respuestaCompleta.split("\\|", 2);
                                if (partes.length == 2) {
                                    String respuestaCliente = partes[0];
                                    String uuidRespuesta = partes[1];

                                    if (uuidRespuesta.equals(emergenciaUUID)) {
                                        System.out.println(" Respuesta : '" + respuestaCliente + "' de: " + remitente);
                                        System.out.println(" id verificado: " + uuidRespuesta);
                                        switch (respuestaCliente.toLowerCase()) {
                                            case "encamino":
                                                System.out.println("El cliente con direccion " + remitente + " está en camino");
                                                break;
                                            case "recibido":
                                                System.out.println("El cliente con direccion " + remitente + " fue notificado de la emergencia pero no nos dio mas info");
                                                break;
                                            case "nodisponible":
                                                System.out.println("el cliente: " + remitente + " no esta disponible");
                                                break;
                                            default:
                                                System.out.println("el cliente respondio esto: '" + respuestaCliente + "' anda a saber que quiso decir");
                                                break;
                                        }

                                        // ✅ Eliminar cliente de pendientes
                                        Iterator<InetSocketAddress> it = clientesPendientes.iterator();
                                        while (it.hasNext()) {
                                            InetSocketAddress c = it.next();
                                            if (c.getPort() == remitente.getPort() &&
                                                    c.getAddress().equals(remitente.getAddress())) {
                                                it.remove();
                                                System.out.println("Cliente " + remitente + " eliminado de la lista");
                                                break;
                                            }
                                        }

                                    } else {
                                        System.out.println("ID inválido recibido de " + remitente + ": " + uuidRespuesta);
                                    }
                                } else {
                                    System.out.println(" Respuesta sin formato correcto de " + remitente + ": " + respuestaCompleta);
                                }

                            } catch (SocketTimeoutException e) {
                                Thread.sleep(4000);
                                System.out.println("reenviando emergencia " + emergenciaUUID + "...");
                            }
                        }
                        System.out.println("Todos los clientes respondieron para la emergencia yupiii este es el codigo de la emergencia: " + emergenciaUUID + "!");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
