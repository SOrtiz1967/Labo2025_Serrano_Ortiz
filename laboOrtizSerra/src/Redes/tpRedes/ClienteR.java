package Redes.tpRedes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteR {
    public static void main(String[] args) {
        int PUERTO_CLIENTE = 6000; // Puerto por defecto

        // Si se pasa un argumento, usarlo como puerto
        if (args.length > 0) {
            PUERTO_CLIENTE = Integer.parseInt(args[0]);
        }

        final String IP_SERVIDOR = "localhost";
        final int PUERTO_RESPUESTAS = 5001; // Puerto DIFERENTE para respuestas

        System.out.println("Cliente escuchando en puerto: " + PUERTO_CLIENTE);

        try (DatagramSocket socket = new DatagramSocket(PUERTO_CLIENTE)) {
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println("Emergencia recibida: " + mensaje);

                // enviar ACK al servidor
                String ack = "RECIBIDO";
                DatagramPacket respuesta = new DatagramPacket(
                        ack.getBytes(),
                        ack.length(),
                        InetAddress.getByName(IP_SERVIDOR),
                        PUERTO_RESPUESTAS  // ← CAMBIO AQUÍ
                );
                socket.send(respuesta);
                System.out.println("ACK enviado desde el puerto " + PUERTO_CLIENTE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}