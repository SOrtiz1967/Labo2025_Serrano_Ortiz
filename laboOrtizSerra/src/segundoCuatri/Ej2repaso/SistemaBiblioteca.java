/*package segundoCuatri.Ej2repaso;
import java.time.LocalDate;
import java.util.HashSet;

public class SistemaBiblioteca {
    private HashSet<Publicacion> publicacionesTotales;
    private HashSet<Prestable> publicacionesPrestables;
    private HashSet<Prestamo> prestamosRealizados;

    // Constructor
    public SistemaBiblioteca() {
        this.publicacionesTotales = new HashSet<>();
        this.publicacionesPrestables = new HashSet<>();
        this.prestamosRealizados = new HashSet<>();
    }

    // Getters y Setters
    public HashSet<Publicacion> getPublicacionesTotales() {
        return publicacionesTotales;
    }

    public void setPublicacionesTotales(HashSet<Publicacion> publicacionesTotales) {
        this.publicacionesTotales = publicacionesTotales;
    }

    public HashSet<Prestable> getPublicacionesPrestables() {
        return publicacionesPrestables;
    }

    public void setPublicacionesPrestables(HashSet<Prestable> publicacionesPrestables) {
        this.publicacionesPrestables = publicacionesPrestables;
    }

    public HashSet<Prestamo> getPrestamosRealizados() {
        return prestamosRealizados;
    }

    public void setPrestamosRealizados(HashSet<Prestamo> prestamosRealizados) {
        this.prestamosRealizados = prestamosRealizados;
    }
    // Tener en cuenta que en nuestro sistema cuando viene un usuario a devolver un préstamo es que se verifica que ese préstamo
    // esté en fecha y al validarse correctamente se le suma uno en la lista de prestamos que hizo y la cantidad de veces.
    // Si esto no sucede, enviar una excepción: “Prestamo devuelto fuera de fecha” y se calcula la multa. Esto devuelve un valor
    // que hay que restarle al crédito del usuario y depende el tipo de publicación.



/*
    // 1. Motor de búsqueda
    public String buscarPublicacion(String nombre) throws Exception {
        for (Publicacion pub : publicacionesTotales) {
            if (pub.getTitulo().equalsIgnoreCase(nombre)) {
                String resultado = "Título: " + pub.getTitulo() +
                        "\nAutor: " + pub.getAutor() +
                        "\nAño de publicación: " + pub.getAnioPublicacion();

                if (pub instanceof Prestable) {
                    resultado += "\nSi quiere tómelo prestado";
                }

                return resultado;
            }
        }
        throw new Exception("No tenemos el libro");
    }
*/
    /*
    // 2. Verificar disponibilidad
    public String verificarDisponibilidad(Publicacion publicacion) throws Exception {
        if (!(publicacion instanceof Prestable)) {
            throw new Exception("No se puede dar a prestamo");
        }

        if (publicacion.getStock() <= 0) {
            throw new Exception("No hay stock suficiente");
        }

        return "Esta disponible para ser prestado";
    }
*/
/*
    // 3. Agregar préstamo
    public void agregarPrestamo(Prestable articulo, int numeroSocio) {
        Prestamo nuevoPrestamo = new Prestamo(articulo, numeroSocio);
        prestamosRealizados.add(nuevoPrestamo);

        // Reducir el stock
        if (articulo instanceof Publicacion) {
            Publicacion pub = (Publicacion) articulo;
            pub.setStock(pub.getStock() - 1);
        }

        System.out.println("Préstamo agregado correctamente");
        System.out.println("Título: " + ((Publicacion)articulo).getTitulo());
        System.out.println("Fecha de devolución: " + nuevoPrestamo.getFechaDevolucionEstimada());
    }
*/
    /*
    // 4. Extender préstamo
    public String extenderPrestamo(Usuario usuario, Prestamo prestamo) throws Exception {
        // Verificar crédito
        if (usuario.getCredito() < 0) {
            throw new Exception("No es posible extender el préstamo");
        }

        Prestable articulo = prestamo.getArticulo();

        // Caso Libro: verificar stock mayor a 5
        if (articulo instanceof Libro) {
            Libro libro = (Libro) articulo;
            if (libro.getStock() <= 5) {
                throw new Exception("No es posible extender el préstamo");
            }
        }

        // Caso Revista: verificar que no tenga otra revista en préstamo activo
        if (articulo instanceof Revista) {
            for (Prestamo p : prestamosRealizados) {
                if (p.getNumeroSocio() == usuario.getNumeroSocio() &&
                        p.getArticulo() instanceof Revista &&
                        !p.equals(prestamo)) {
                    throw new Exception("No es posible extender el préstamo");
                }
            }
        }

        // Extender la fecha de devolución
        prestamo.setFechaDevolucionEstimada(articulo.darPrestamo());

        return "Prestamo extendido";
    }

     */