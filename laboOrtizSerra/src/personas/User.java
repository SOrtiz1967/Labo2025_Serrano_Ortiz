package personas;

public class User {
    //guardar nombre, apellido, celular del cliente y método de pago
    // (si es con tarjeta, 5 % de recargo y datos de la tarjeta).
    private String nombre;
    private String apellido;
    private int telefono;

    public User(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
