package segundoCuatri.Ej2repaso;
import java.time.LocalDate;

public class Prestamo {
    private Prestable articulo;
    private int numeroSocio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEstimada;

    // Constructor
    public Prestamo(Prestable articulo, int numeroSocio) {
        this.articulo = articulo;
        this.numeroSocio = numeroSocio;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucionEstimada = articulo.darPrestamo();
    }

    // Getters y Setters
    public Prestable getArticulo() {
        return articulo;
    }

    public void setArticulo(Prestable articulo) {
        this.articulo = articulo;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucionEstimada() {
        return fechaDevolucionEstimada;
    }

    public void setFechaDevolucionEstimada(LocalDate fechaDevolucionEstimada) {
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
    }
}