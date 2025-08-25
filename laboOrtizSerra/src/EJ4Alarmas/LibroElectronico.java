package EJ4Alarmas;

public class LibroElectronico {
    private Genero genero;
    private String titulo;
    private Autor autorlibro;
    private String nombreDeArchivoPDF;
    private int cantidadDeVecesDescargable=145;

    public LibroElectronico(Genero genero, String titulo, Autor autorlibro, String nombreDeArchivoPDF) {
        this.genero = genero;
        this.titulo = titulo;
        this.autorlibro = autorlibro;
        this.nombreDeArchivoPDF = nombreDeArchivoPDF;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutorlibro() {
        return autorlibro;
    }

    public void setAutorlibro(Autor autorlibro) {
        this.autorlibro = autorlibro;
    }

    public String getNombreDeArchivoPDF() {
        return nombreDeArchivoPDF;
    }

    public void setNombreDeArchivoPDF(String nombreDeArchivoPDF) {
        this.nombreDeArchivoPDF = nombreDeArchivoPDF;
    }

    public int getCantidadDeVecesDescargable() {
        return cantidadDeVecesDescargable;
    }

    public void setCantidadDeVecesDescargable(int cantidadDeVecesDescargable) {
        this.cantidadDeVecesDescargable = cantidadDeVecesDescargable;
    }
}
