package Redes;

public class MiRunnable implements Runnable {
    private final String parametro;

    public MiRunnable(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        // Lógica del hilo, usando el parámetro 'parametro'
        System.out.println("Hilo corriendo con parámetro: " + parametro);
    }
}
