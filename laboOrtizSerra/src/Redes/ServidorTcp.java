package Redes;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ServidorTcp {

    private static AtomicInteger contadorClientes = new AtomicInteger(1);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            System.out.println("Servidor esperando conexiones...");
            while (true) {
                Socket socketCliente = serverSocket.accept();
                int clienteId = contadorClientes.getAndIncrement();
                System.out.println("Cliente " + clienteId + " conectado.");
                // Crear un hilo para manejar a cada cliente
                new Thread(() -> manejarCliente(socketCliente, clienteId)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void manejarCliente(Socket socket, int clienteId) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            Thread receptor = new Thread(() -> {
                try {
                    String mensaje;
                    while ((mensaje = in.readLine()) != null) {
                        System.out.println("Cliente " + clienteId + " dice: " + mensaje);
                        if (mensaje.equalsIgnoreCase("chau")) {
                            System.out.println("Cliente " + clienteId + " finalizó la conexión.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread emisor = new Thread(() -> {
                while (true) {
                    System.out.print("Responder a Cliente " + clienteId + " > ");
                    String respuesta = scanner.nextLine();
                    out.println(respuesta);
                    if (respuesta.equalsIgnoreCase("chau")) {
                        break;
                    }
                }
            });
            receptor.start();
            emisor.start();
            receptor.join();
            socket.close();
            System.out.println("Conexión con Cliente " + clienteId + " cerrada.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
