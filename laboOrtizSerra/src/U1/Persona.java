package U1;

public class Persona {
    private String nombre;
    private int edad;
    private String direccion;

    public Persona(){
        this.nombre="Juan";
        this.edad=22;
        this.direccion="alsina 568";
    }
    public Persona(String nombre, int edad, String dieccion){
        this.nombre=nombre;
        this.edad=edad;
        this.direccion=direccion;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Dirección: " + direccion);
    }

}
