package Redes.tpRedes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ClienteR {
    public static void main(String[] args) {
        int PUERTO_CLIENTE = 6000; // Puerto default

        if (args.length > 0) {
            PUERTO_CLIENTE = Integer.parseInt(args[0]);
        }

        final String IP_SERVIDOR = "172.16.4.176";
        final int PUERTO_RESPUESTAS = 5001;

        System.out.println("Cliente escuchando en puerto: " + PUERTO_CLIENTE);
        System.out.println("Podes responder lo que quieras");

        try (DatagramSocket socket = new DatagramSocket(PUERTO_CLIENTE);
             Scanner scanner = new Scanner(System.in)) {

            byte[] buffer = new byte[1024];
            Set<String> uuidsRespondidos = new HashSet<>(); // ñara evitar duplicados por UUID

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensajeCompleto = new String(paquete.getData(), 0, paquete.getLength()).trim();

                // Parsear "incendio|uuid-123-456"
                String[] partes = mensajeCompleto.split("\\|", 2);
                if (partes.length != 2) {//si el formato no es valido
                    System.out.println(" Mensaje sin formato correcto recibido: " + mensajeCompleto);
                    continue;
                }

                String emergencia = partes[0];
                String uuid = partes[1];

                // chequear si la eemergencia ya c repondio
                if (uuidsRespondidos.contains(uuid)) {
                    System.out.println("Emergencias duplicadas ignoradas ");
                    continue;
                }


                System.out.println("\nEmergencia recibida: " + emergencia);
                System.out.println("UUID: " + uuid);

                System.out.print("Ingresa respuesta 🤔🤔🤔🤔🤔🤔🤔: ");
                String respuestaUsuario = scanner.nextLine().trim();

                // Respuesta por defecto si igresa cualquier cosa
                String respuestaCliente = respuestaUsuario.isEmpty() ? "RECIBIDO" : respuestaUsuario;

                // creamos la respueta con el UUID
                String respuestaConUUID = respuestaCliente + "|" + uuid;//a lo q se ingresa le agregamos el id

                DatagramPacket respuesta = new DatagramPacket(
                        respuestaConUUID.getBytes(),
                        respuestaConUUID.length(),
                        InetAddress.getByName(IP_SERVIDOR),
                        PUERTO_RESPUESTAS
                );
                socket.send(respuesta);

                // AGREGAR LOS UUID RESPONDIDOS
                uuidsRespondidos.add(uuid);

                System.out.println("Emergencia procesada (dedito para arriba)");
                System.out.println("pronto para prosecar mas emergencias \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}