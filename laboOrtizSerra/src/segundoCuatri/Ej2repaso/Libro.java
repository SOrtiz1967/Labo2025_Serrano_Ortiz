package segundoCuatri.Ej2repaso;
import java.time.LocalDate;

public class Libro extends Publicacion implements Prestable {
    private boolean tieneSaga;
    private static final double MULTA = 7500.0;
    private static final int DIAS_PRESTAMO = 15;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion, int stock, boolean tieneSaga) {
        super(titulo, autor, anioPublicacion, stock);
        this.tieneSaga = tieneSaga;
    }

    // Getters y Setters
    public boolean isTieneSaga() {
        return tieneSaga;
    }

    public void setTieneSaga(boolean tieneSaga) {
        this.tieneSaga = tieneSaga;
    }

    // Implementación de Prestable
    @Override
    public LocalDate darPrestamo() {
        return LocalDate.now().plusDays(DIAS_PRESTAMO);
    }

    @Override
    public double calcularMulta() {
        return MULTA;
    }
}