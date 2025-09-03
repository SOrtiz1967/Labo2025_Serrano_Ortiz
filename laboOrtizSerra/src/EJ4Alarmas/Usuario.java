package EJ4Alarmas;

import primerCuatri.probar.personas.Persona;

import java.util.HashSet;
import java.util.Map;

public class Usuario extends Persona {
    private String mail;
    private Membresia membresia;
    private int librosquepuedepedir;
    private HashSet<LibroElectronico> librosPedidos;

    public void valorLibrosquepuedepedir() {
        for (Map.Entry<Membresia, Integer> m : Biblioteca.librosPrestados().entrySet()) {
            if (m.getKey().equals(this.membresia)) {
                this.librosquepuedepedir = m.getValue();
            }
        }
    }
    public Usuario(String nombre, int edad, String apellido, String direccion, String mail, Membresia membresia) {
        super(nombre, edad, apellido, direccion);
        this.mail = mail;
        this.membresia = membresia;
        this.valorLibrosquepuedepedir();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public int getLibrosquepuedepedir() {
        return librosquepuedepedir;
    }

    public void setLibrosquepuedepedir(int librosquepuedepedir) {
        this.librosquepuedepedir = librosquepuedepedir;
    }
}
