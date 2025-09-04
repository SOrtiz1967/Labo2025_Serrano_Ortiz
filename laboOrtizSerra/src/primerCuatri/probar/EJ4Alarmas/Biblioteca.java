package primerCuatri.probar.EJ4Alarmas;

import java.util.HashMap;
import java.util.HashSet;

public class Biblioteca {
    private HashSet<LibroElectronico> libros;
    private HashSet<Usuario> usuarios;
    private HashMap<Membresia, Integer> librosPrestados = librosPrestados();

    public static HashMap<Membresia, Integer> librosPrestados() {
        HashMap<Membresia, Integer> librosPrestados = new HashMap<Membresia, Integer>();
        librosPrestados.put(Membresia.BRONCE, 5);
        librosPrestados.put(Membresia.PLATA, 15);
        librosPrestados.put(Membresia.ORO, 50);
        return librosPrestados;
    }

    public void LibroPrestado(LibroElectronico libro, Usuario usuario) {
        try {
            if (libro.getCantidadDeVecesDescargable() <= 0) {
                throw new LimiteDePrestamosAlcanzadoException("El libro no tiene más préstamos disponibles");
            }
            if (usuario.getLibrosquepuedepedir() <= 0) {
                throw new MembresiaException("El usuario no tiene más préstamos disponibles");
            }
        } catch (LimiteDePrestamosAlcanzadoException e) {
            e.getMessage();
        } catch (MembresiaException e) {
            throw new RuntimeException(e);
        }
        libro.setCantidadDeVecesDescargable(libro.getCantidadDeVecesDescargable() - 1);
        usuario.setLibrosquepuedepedir(usuario.getLibrosquepuedepedir() - 1);
        this.eliminarLibro(libro);
    }
    public void LibroDevuelto(LibroElectronico libro){
        this.agregarLibro(libro);
    }
    public void agregarLibro(LibroElectronico libro) {
        this.libros.add(libro);
    }
    public void eliminarLibro(LibroElectronico libro){
        this.libros.remove(libro);
    }
    public void modificarLibro(LibroElectronico libroNuevo, LibroElectronico libroViejo){
        agregarLibro(libroNuevo);
        eliminarLibro(libroViejo);
    }

}