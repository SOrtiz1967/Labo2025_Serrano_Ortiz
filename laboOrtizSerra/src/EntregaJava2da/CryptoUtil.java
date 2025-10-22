package EntregaJava2da;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class CryptoUtil {

    // Generar par de claves RSA (asimétrica)
    public static KeyPair generarParClaves() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    // Generar clave AES aleatoria (simétrica)
    public static SecretKey generarClaveAES() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(256);
        return kg.generateKey();
    }

    // Encriptar con AES (simétrica)
    public static String encriptarAES(String mensaje, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] encriptado = cipher.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(encriptado);
    }

    // Desencriptar con AES (simétrica)
    public static String desencriptarAES(String mensajeEncriptado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] decodificado = Base64.getDecoder().decode(mensajeEncriptado);
        byte[] desencriptado = cipher.doFinal(decodificado);
        return new String(desencriptado);
    }

    // Encriptar con RSA (asimétrica) - para intercambiar la clave AES
    public static String encriptarRSA(byte[] datos, PublicKey clavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] encriptado = cipher.doFinal(datos);
        return Base64.getEncoder().encodeToString(encriptado);
    }

    // Desencriptar con RSA (asimétrica)
    public static byte[] desencriptarRSA(String datosEncriptados, PrivateKey clavePrivada) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] decodificado = Base64.getDecoder().decode(datosEncriptados);
        return cipher.doFinal(decodificado);
    }

    // Crear firma digital
    public static String firmarMensaje(String mensaje, PrivateKey clavePrivada) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(clavePrivada);
        signature.update(mensaje.getBytes());
        byte[] firma = signature.sign();
        return Base64.getEncoder().encodeToString(firma);
    }

    // Verificar firma digital
    public static boolean verificarFirma(String mensaje, String firmaBase64, PublicKey clavePublica) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(clavePublica);
        signature.update(mensaje.getBytes());
        byte[] firma = Base64.getDecoder().decode(firmaBase64);
        return signature.verify(firma);
    }

    // Convertir clave pública a String
    public static String clavePublicaAString(PublicKey clave) {
        return Base64.getEncoder().encodeToString(clave.getEncoded());
    }

    // Convertir String a clave pública
    public static PublicKey stringAClavePublica(String claveStr) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(claveStr);
        return KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(bytes));
    }

    // Convertir SecretKey a String
    public static String claveAESAString(SecretKey clave) {
        return Base64.getEncoder().encodeToString(clave.getEncoded());
    }

    // Convertir String a SecretKey
    public static SecretKey stringAClaveAES(String claveStr) {
        byte[] bytes = Base64.getDecoder().decode(claveStr);
        return new SecretKeySpec(bytes, "AES");
    }
}