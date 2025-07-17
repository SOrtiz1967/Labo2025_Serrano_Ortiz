package Redes;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTcp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Thread receptor = new Thread(() -> {
                try {
                    String respuesta;
                    while ((respuesta = in.readLine()) != null) {
                        System.out.println("Servidor dice: " + respuesta);
                        if (respuesta.equalsIgnoreCase("chau")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread emisor = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("Cliente > ");
                    String mensaje = scanner.nextLine();
                    out.println(mensaje);
                    if (mensaje.equalsIgnoreCase("chau")) {
                        break;
                    }
                }
            });
            receptor.start();
            emisor.start();
            receptor.join();
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
