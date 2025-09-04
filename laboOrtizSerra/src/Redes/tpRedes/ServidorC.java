package Redes.tpRedes;

import Redes.MiRunnable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ServidorC {
    public static void main(String[] args) {
        final int PUERTO_EMERGENCIAS = 5000;
        final int PUERTO_RESPUESTAS = 5001;

        try (DatagramSocket socketEmergencias = new DatagramSocket(PUERTO_EMERGENCIAS);
             DatagramSocket socketRespuestas = new DatagramSocket(PUERTO_RESPUESTAS)) {

            socketRespuestas.setSoTimeout(5000); // 5 segundos timeout
            System.out.println("Servidor escuchando emergencias en puerto " + PUERTO_EMERGENCIAS);
            System.out.println("Servidor escuchando respuestas en puerto " + PUERTO_RESPUESTAS);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteR = new DatagramPacket(buffer, buffer.length);
                socketEmergencias.receive(paqueteR);

                String mensajeOriginal = new String(paqueteR.getData(), 0, paqueteR.getLength());

                // Generamos un UUID único para c emergen
                String emergenciaUUID = UUID.randomUUID().toString();
                String mensajeConUUID = mensajeOriginal + "|" + emergenciaUUID;//lo conatenamos

                System.out.println("Emergencia recibida del agente: " + mensajeOriginal);
                System.out.println("mensaje con el id: " + emergenciaUUID);

                //cuando la emergencia es un incendio
                if (mensajeOriginal.equalsIgnoreCase("incendio")) {
                    MiRunnable miRunnable = new MiRunnable("Hilo abierto como .....");
                    new Thread(miRunnable).start();
                }

                //clientes pendientes
                List<InetSocketAddress> clientesPendientes = new ArrayList<>();
                clientesPendientes.add(new InetSocketAddress("localhost", 6000));
                clientesPendientes.add(new InetSocketAddress("localhost", 6001));
                clientesPendientes.add(new InetSocketAddress("localhost", 6002));
                //PARA PROBAR CON un sol cliente comento los otros 2
                new Thread(() -> {
                    try {
                        // reenviar
                        while (!clientesPendientes.isEmpty()) {
                            // Enviar mensaje con UUID a clientes pendientes
                            for (InetSocketAddress cliente : clientesPendientes) {
                                DatagramPacket alerta = new DatagramPacket(
                                        mensajeConUUID.getBytes(),
                                        mensajeConUUID.length(),
                                        cliente.getAddress(),
                                        cliente.getPort()
                                );
                                socketEmergencias.send(alerta);
                                System.out.println(" Enviando a " + cliente + ": " + mensajeConUUID);
                            }


                            try {
                                DatagramPacket respuesta = new DatagramPacket(new byte[1024], 1024);
                                socketRespuestas.receive(respuesta);

                                String respuestaCompleta = new String(respuesta.getData(), 0, respuesta.getLength());
                                InetSocketAddress remitente = new InetSocketAddress(respuesta.getAddress(), respuesta.getPort());

                                // Parsear respuesta: "EN_CAMINO|uuid-123-456"
                                String[] partes = respuestaCompleta.split("\\|", 2);
                                if (partes.length == 2) {
                                    String respuestaCliente = partes[0];
                                    String uuidRespuesta = partes[1];

                                    // comprobar el id
                                    if (uuidRespuesta.equals(emergenciaUUID)) {
                                        System.out.println(" Respuesta válida: '" + respuestaCliente + "' de: " + remitente);
                                        System.out.println(" id verificado: " + uuidRespuesta);

                                        // Eliminar cliente de pendientes
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
                                System.out.println(" Timeout - reenviando emergencia " + emergenciaUUID + "...");
                            }
                        }
                        System.out.println("Todos los clientes respondieron para emergencia yupiii " + emergenciaUUID + "!");

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