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
        final int PUERTO_EMERGENCIAS = 5000;
        final int PUERTO_RESPUESTAS = 5001;

        try (DatagramSocket socketEmergencias = new DatagramSocket(PUERTO_EMERGENCIAS);
             DatagramSocket socketRespuestas = new DatagramSocket(PUERTO_RESPUESTAS)) {

            socketRespuestas.setSoTimeout(1000); // las respuestas tienen un timeout
            System.out.println("Servidor escuchando emergencias en puerto " + PUERTO_EMERGENCIAS);
            System.out.println("Servidor escuchando respuestas en puerto " + PUERTO_RESPUESTAS);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteR = new DatagramPacket(buffer, buffer.length);
                socketEmergencias.receive(paqueteR);

                String mensaje = new String(paqueteR.getData(), 0, paqueteR.getLength());
                System.out.println("Emergencia recibida del agente: " + mensaje);


                if (mensaje.equalsIgnoreCase("incendio")) {
                    MiRunnable miRunnable = new MiRunnable("Hilo abierto");
                    new Thread(miRunnable).start();
                }

                // lista de clientes pendientes (se reinicia con cada emergencia
                List<InetSocketAddress> clientesPendientes = new ArrayList<>();
                clientesPendientes.add(new InetSocketAddress("localhost", 6000)); // Cliente 1
                //clientesPendientes.add(new InetSocketAddress("localhost", 6001)); // Cliente 2
                //clientesPendientes.add(new InetSocketAddress("localhost", 6002)); // Cliente 3
                new Thread(() -> {
                    try {
                        // reenvio a clientes hasta que todos respondan
                        while (!clientesPendientes.isEmpty()) {
                            // enviar a cada cliente pendiente
                            for (InetSocketAddress cliente : clientesPendientes) {
                                DatagramPacket alerta = new DatagramPacket(
                                        mensaje.getBytes(),
                                        mensaje.length(),
                                        cliente.getAddress(),
                                        cliente.getPort()
                                );
                                socketEmergencias.send(alerta);
                            }

                            // intentar recibir respuesta
                            try {
                                DatagramPacket respuesta = new DatagramPacket(new byte[1024], 1024);
                                socketRespuestas.receive(respuesta);

                                String ack = new String(respuesta.getData(), 0, respuesta.getLength());
                                InetSocketAddress remitente = new InetSocketAddress(respuesta.getAddress(), respuesta.getPort());

                                if (ack.equalsIgnoreCase("RECIBIDO")) {
                                    System.out.println("Respuesta de: " + remitente);

                                    // eliminar de la lista si contesta
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
                                // nadie respondió, continuar intentando
                                System.out.println("reenviando");
                            }
                        }
                        // todos respondieron y sale del bucle
                        System.out.println("todos los clientes respondieron");

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