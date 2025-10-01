package segundoCuatri.Ej2repaso;
import java.time.LocalDate;

public class Revista extends Publicacion implements Prestable {
    private String nombreDistribuidora;
    private static final double MULTA = 3500.0;
    private static final int DIAS_PRESTAMO_ANTIGUA = 10;
    private static final int DIAS_PRESTAMO_RECIENTE = 3;
    private static final int ANIO_CORTE = 2020;

    // Constructor
    public Revista(String titulo, String autor, int anioPublicacion, int stock, String nombreDistribuidora) {
        super(titulo, autor, anioPublicacion, stock);
        this.nombreDistribuidora = nombreDistribuidora;
    }

    // Getter y Setter
    public String getNombreDistribuidora() {
        return nombreDistribuidora;
    }

    public void setNombreDistribuidora(String nombreDistribuidora) {
        this.nombreDistribuidora = nombreDistribuidora;
    }

    // Implementación de Prestable
    @Override
    public LocalDate darPrestamo() {
        if (getAnioPublicacion() < ANIO_CORTE) {
            return LocalDate.now().plusDays(DIAS_PRESTAMO_ANTIGUA);
        } else {
            return LocalDate.now().plusDays(DIAS_PRESTAMO_RECIENTE);
        }
    }

    @Override
    public double calcularMulta() {
        return MULTA;
    }
}