package Redes.tpRedes;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class AgenteE {
    public static void main(String[] args) {
        final String HOST = "localhost"; //para probar en la compu anashe
        final int PUERTO_SERVIDOR = 5000;

        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Agente ready pal laburo");

            while (true) {
                System.out.print("Ingresa emergencia");
                String mensaje = scanner.nextLine();

                if (mensaje.equalsIgnoreCase("salir")) break;

                byte[] datos = mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(
                        datos,
                        datos.length,
                        InetAddress.getByName(HOST),
                        PUERTO_SERVIDOR
                );

                socket.send(paquete);
                System.out.println("Emergencia enviada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
