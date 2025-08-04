package PagoDeEmpleados;

import java.util.HashSet;

public class Proyecto {
    private String nombre;
    private int precio;

    public Proyecto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Proyecto() {
        this.nombre = "web";
        this.precio = 800;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
