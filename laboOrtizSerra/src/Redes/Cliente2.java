package Redes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente2 {
    public static void main(String[] args) {
        final int puerto=20000;
        byte[]buffer=new byte[1024];
        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketCliente = new DatagramSocket();
            String mensaje = "Holaa";
            buffer = mensaje.getBytes();
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto);
            System.out.println("Envio el paquete");
            socketCliente.send(pregunta);
            buffer=new byte[1024];
            DatagramPacket mensajeServidor = new DatagramPacket(buffer, buffer.length);
            socketCliente.receive(mensajeServidor);
            System.out.println("Recibido el mensaje");
            mensaje = new String(mensajeServidor.getData());
            System.out.println(mensaje);
            socketCliente.close();

        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
