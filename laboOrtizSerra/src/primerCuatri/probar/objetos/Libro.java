package primerCuatri.probar.objetos;

import fecha.Fecha;
import primerCuatri.probar.personas.Persona;

public class Libro {
    /*
    Atributos: título, autor (usar la clase Persona), ISBN, páginas,
    editorial, fechaPublicacion (usar la clase Fecha)
     */
    private String titulo;
    private Persona autor;
    private int ISBN;
    private int paginas;
    private Editorial editorial;
    private Fecha fechaPublicacion;

    //constructor por defecto :>
    public Libro(){
        this.titulo="las escalofriantes aventuras de Benja y su secuaz miguelini borjini asadini";
        this.autor= new Persona();
        this.ISBN=9122018;
        this.paginas=912;
        this.editorial=Editorial.KAPELUSZ;
        this.fechaPublicacion=new Fecha();
    }
    //constructor parametrizado:<
    public Libro(String titulo, Persona autor, int ISBN, int paginas, Editorial editorial, Fecha fechaPublicacion) {
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
        this.editorial=Editorial.SUDAMERICANA;
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

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
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
