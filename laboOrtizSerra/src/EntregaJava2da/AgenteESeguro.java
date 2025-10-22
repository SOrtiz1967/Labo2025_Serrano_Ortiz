package EntregaJava2da;



import javax.crypto.SecretKey;
import java.net.*;
import java.security.*;
import java.util.Scanner;

public class AgenteESeguro {
    private static KeyPair parClaves;
    private static PublicKey clavePublicaServidor;
    private static SecretKey claveAESCompartida;

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO_SERVIDOR = 5000;
        final int PUERTO_INTERCAMBIO = 5003;

        try {
            // Generar par de claves RSA del agente
            parClaves = CryptoUtil.generarParClaves();
            System.out.println("🔐 Claves RSA del agente generadas");

            // Obtener claves del servidor
            DatagramSocket socketIntercambio = new DatagramSocket();

            // Solicitar claves al servidor
            String solicitud = "REQUEST_KEY|AGENTE_" + System.currentTimeMillis();
            DatagramPacket paqueteSolicitud = new DatagramPacket(
                    solicitud.getBytes(),
                    solicitud.length(),
                    InetAddress.getByName(HOST),
                    PUERTO_INTERCAMBIO
            );
            socketIntercambio.send(paqueteSolicitud);

            System.out.println("🔄 Solicitando claves al servidor...");

            // Recibir respuesta
            byte[] buffer = new byte[4096];
            DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);
            socketIntercambio.receive(paqueteRespuesta);

            String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());

            if (respuesta.startsWith("SERVER_KEYS|")) {
                String[] partes = respuesta.split("\\|", 3);
                String clavePublicaStr = partes[1];
                String claveAESStr = partes[2];

                clavePublicaServidor = CryptoUtil.stringAClavePublica(clavePublicaStr);
                claveAESCompartida = CryptoUtil.stringAClaveAES(claveAESStr);

                System.out.println("✅ Claves del servidor recibidas");
                System.out.println("🔑 Clave AES compartida obtenida");
            }

            // Enviar clave pública del agente al servidor
            String clavePublicaAgenteStr = CryptoUtil.clavePublicaAString(parClaves.getPublic());
            String mensajeClavePublica = "CLIENT_KEY|AGENTE|" + clavePublicaAgenteStr;
            DatagramPacket paqueteClavePublica = new DatagramPacket(
                    mensajeClavePublica.getBytes(),
                    mensajeClavePublica.length(),
                    InetAddress.getByName(HOST),
                    PUERTO_INTERCAMBIO
            );
            socketIntercambio.send(paqueteClavePublica);
            System.out.println("📤 Clave pública del agente enviada al servidor");

            socketIntercambio.close();

            // Ahora iniciar comunicación normal
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n🚨 Agente listo para reportar emergencias (mensajes encriptados)");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

            while (true) {
                System.out.print("Ingresa emergencia: ");
                String mensaje = scanner.nextLine();

                if (mensaje.equalsIgnoreCase("salir")) break;

                // Encriptar mensaje con AES
                String mensajeEncriptado = CryptoUtil.encriptarAES(mensaje, claveAESCompartida);

                // Firmar el mensaje encriptado con la clave privada del agente
                String firma = CryptoUtil.firmarMensaje(mensajeEncriptado, parClaves.getPrivate());

                // Formato: MENSAJE_ENCRIPTADO|FIRMA
                String paqueteCompleto = mensajeEncriptado + "|FIRMA|" + firma;

                DatagramPacket paquete = new DatagramPacket(
                        paqueteCompleto.getBytes(),
                        paqueteCompleto.length(),
                        InetAddress.getByName(HOST),
                        PUERTO_SERVIDOR
                );

                socket.send(paquete);
                System.out.println("✅ Emergencia enviada (encriptada + firmada)");
                System.out.println("🔒 Longitud del paquete: " + paqueteCompleto.length() + " bytes\n");
            }

            socket.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}