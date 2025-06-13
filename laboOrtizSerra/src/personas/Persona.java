package personas;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;

    public Persona(){
        this.nombre="Juan";
        this.apellido="Gomez";
        this.edad=22;
        this.direccion="alsina 568";
    }
    public Persona(String nombre, int edad,String apellido, String direccion){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.direccion=direccion;
    }

    public Persona(String nombre, int edad ){
        this.nombre=nombre;
        this.edad=edad;
        this.direccion="x xxxx";
    }



    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getDireccion() {
        return direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String imprimirDatos() {
        System.out.println("Nombre: " + nombre + "Edad: " + edad+ "Dirección: " + direccion);
        return ("Nombre: " + nombre + "Edad: " + edad+ "Dirección: " + direccion);

    }
    public boolean esMayor(int age){
        if (edad>age){
            return true;
        }
        else {
            return false;
        }
    }

}
