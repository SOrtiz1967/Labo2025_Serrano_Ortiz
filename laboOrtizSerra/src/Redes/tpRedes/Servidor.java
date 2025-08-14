package Redes.tpRedes;

import Redes.MiRunnable;

import java.io.IOException;
import java.net.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        final int puerto=20000;
        byte[]buffer=new byte[1024];

            try{
                System.out.println("Iniciado el servidor UDP");
                DatagramSocket socket= new DatagramSocket(puerto);
                    while(true){
                        DatagramPacket paqueteRecibido=new DatagramPacket(buffer,buffer.length);
                        socket.receive(paqueteRecibido);
                        System.out.println("Info recibida");
                        String mensaje= new String(paqueteRecibido.getData());
                        System.out.println(mensaje);
                        int puertoCliente = paqueteRecibido.getPort();
                        InetAddress direccion = paqueteRecibido.getAddress();
                        MiRunnable miRunnable = new MiRunnable("Hola desde el hilo");
                        Thread hilo = new Thread(miRunnable);
                        hilo.start();
                        hilo.sleep(10000);
                        mensaje="perejil";
                        buffer=mensaje.getBytes();
                        DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                        System.out.println("Envio la informacion del cliente");
                        socket.send(respuesta);
                        hilo.interrupt();
                    }
        }catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

