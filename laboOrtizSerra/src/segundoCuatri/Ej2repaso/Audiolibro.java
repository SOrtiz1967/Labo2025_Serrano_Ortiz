package segundoCuatri.Ej2repaso;

public class Audiolibro extends Publicacion {
    private int duracion; // en minutos
    private double pesoArchivo; // en MB

    // Constructor
    public Audiolibro(String titulo, String autor, int anioPublicacion, int stock, int duracion, double pesoArchivo) {
        super(titulo, autor, anioPublicacion, stock);
        this.duracion = duracion;
        this.pesoArchivo = pesoArchivo;
    }

    // Getters y Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(double pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }
}