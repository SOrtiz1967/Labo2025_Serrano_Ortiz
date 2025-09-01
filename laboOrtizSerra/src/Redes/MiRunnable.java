package Redes;

public class MiRunnable implements Runnable {
    private String mensaje;

    public MiRunnable(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            System.out.println("🔥 " + mensaje + " - Iniciando protocolo especial para inceendios");
            System.out.println(" Llamando bomberos...");
            Thread.sleep(2000); // Simula tiempo de procesamiento

            System.out.println("Enviando camiones de bomberos... uiuiuiuiuiuiuiuiu pipipipipi");
            Thread.sleep(1500);

            System.out.println("📞 Notificando autoridades");
            Thread.sleep(1000);

            System.out.println(" Protocolo de incendio completado - Hilo: " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("❌ Protocolo de incendio interrumpido");
            Thread.currentThread().interrupt();
        }
    }
}