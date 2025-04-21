package objetos;

import fecha.Fecha;
import personas.Persona;

public class Libro {
    /*
    Atributos: título, autor (usar la clase Persona), ISBN, páginas,
    editorial, fechaPublicacion (usar la clase Fecha)
     */
    private String titulo;
    private Persona autor;
    private int ISBN;
    private int paginas;
    private String editorial;
    private Fecha fechaPublicacion;

    //constructor por defecto :>
    public Libro(){
        this.titulo="las escalofriantes aventuras de Benja y su secuaz miguelini borjini asadini";
        this.autor= new Persona();
        this.ISBN=9122018;
        this.paginas=912;
        this.editorial="siameses";
        this.fechaPublicacion=new Fecha();
    }
    //constructor parametrizado:<
    public Libro(String titulo, Persona autor, int ISBN, int paginas, String editorial, Fecha fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.paginas = paginas;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;

    }
    //constructor mitad y mitad
    public Libro(String titulo){
        this.titulo = titulo;
        this.autor= new Persona();
        this.ISBN=9122018;
        this.paginas=912;
        this.editorial="siameses";
        this.fechaPublicacion=new Fecha();
    }
    //getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Fecha getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Fecha fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
     //metodos :)
    public void mostrarDatos() {
        System.out.println("titulo: " + this.titulo);
        System.out.println("autor: " + autor.imprimirDatos() );
        System.out.println("ISBN: " + this.ISBN);
        System.out.println("paginas: "+this.paginas);
        System.out.println("editorial:"+ this.editorial);
        System.out.println("fecha publicacion: "+ fechaPublicacion.corta());
}

    public boolean mayorQue(Fecha fAux){
        return this.fechaPublicacion.mayorQue(fAux);
    }
}
