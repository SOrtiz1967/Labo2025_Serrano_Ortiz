package Redes.tpRedes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClienteR {
    public static void main(String[] args) {
        final int PUERTO_CLIENTE = 6000; // Cambiar a 6001 o 6002 para otros clientes
        final String IP_SERVIDOR = "localhost";
        final int PUERTO_SERVIDOR = 5000;

        try (DatagramSocket socket = new DatagramSocket(PUERTO_CLIENTE)) {
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println("Emergencia recibida: " + mensaje);

                // Enviar ACK al servidor
                String ack = "RECIBIDO";
                DatagramPacket respuesta = new DatagramPacket(
                        ack.getBytes(),
                        ack.length(),
                        InetAddress.getByName(IP_SERVIDOR),
                        PUERTO_SERVIDOR
                );
                socket.send(respuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
