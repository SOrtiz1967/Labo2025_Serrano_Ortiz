package segundoCuatri.Vacunatorio;

public class Ciudadano {
    /*De cada ciudadano tenemos dni, nombre y apellido, provincia de residencia, domicilio y mail de contacto.*/
    private int dni;
    private String nombre;
    private String apellido;
    private String provincia;
    private String mail;

    public Ciudadano(int dni, String nombre, String apellido, String provincia, String mail) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
        this.mail = mail;
    }
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
