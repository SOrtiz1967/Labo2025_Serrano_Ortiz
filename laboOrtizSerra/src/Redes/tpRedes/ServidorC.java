package Redes.tpRedes;

import Redes.MiRunnable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServidorC {
    public static void main(String[] args) {
        final int pServer = 5000;

        try (DatagramSocket socket = new DatagramSocket(pServer)) {
            socket.setSoTimeout(1000); // 1 segundo de delay para recibir respuesta
            System.out.println("Servidor escuchando emergencias en puerto " + pServer);

            while (true) {
                // Esperar el msj del agente
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteR = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteR);

                String mensaje = new String(paqueteR.getData(), 0, paqueteR.getLength());
                System.out.println("Emergencia recibida del agente: " + mensaje);

                // Ejemplo: iniciar un hilo extra si la emergencia es incendio
                if (mensaje.equalsIgnoreCase("incendio")) {
                    MiRunnable miRunnable = new MiRunnable("Hilo abierto");
                    new Thread(miRunnable).start();
                }

                // Lista de clientes pendientes (se reinicia para cada emergencia)
                List<InetSocketAddress> clientesPendientes = new ArrayList<>();
                clientesPendientes.add(new InetSocketAddress("localhost", 6000)); // Cliente 1
                clientesPendientes.add(new InetSocketAddress("localhost", 6001)); // Cliente 2
                clientesPendientes.add(new InetSocketAddress("localhost", 6002)); // Cliente 3

                // Lanzar un hilo para manejar el reenvío y la espera de respuestas
                new Thread(() -> {
                    try {
                        // Reenvío a clientes hasta que todos respondan
                        while (!clientesPendientes.isEmpty()) {
                            // Enviar a cada cliente pendiente
                            for (InetSocketAddress cliente : clientesPendientes) {
                                DatagramPacket alerta = new DatagramPacket(
                                        mensaje.getBytes(),
                                        mensaje.length(),
                                        cliente.getAddress(),
                                        cliente.getPort()
                                );
                                socket.send(alerta);
                            }

                            // Intentar recibir respuesta
                            try {
                                DatagramPacket respuesta = new DatagramPacket(new byte[1024], 1024);
                                socket.receive(respuesta);

                                String ack = new String(respuesta.getData(), 0, respuesta.getLength());
                                InetSocketAddress remitente = new InetSocketAddress(respuesta.getAddress(), respuesta.getPort());

                                if (ack.equalsIgnoreCase("RECIBIDO")) {
                                    System.out.println("✅ Respuesta de: " + remitente);

                                    // Eliminar de la lista si responde
                                    Iterator<InetSocketAddress> it = clientesPendientes.iterator();
                                    while (it.hasNext()) {
                                        InetSocketAddress c = it.next();
                                        if (c.getPort() == remitente.getPort() &&
                                                c.getAddress().equals(remitente.getAddress())) {
                                            it.remove();
                                            break;
                                        }
                                    }
                                }
                            } catch (SocketTimeoutException e) {
                                // Nadie respondió, continuar intentando
                            }
                        }
                        // sale del bucle → todos respondieron
                        System.out.println("Todos los clientes respondieron ✅");

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
