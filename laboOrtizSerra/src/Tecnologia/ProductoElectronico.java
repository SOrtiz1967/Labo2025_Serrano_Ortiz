package Tecnologia;

import objetos.Seccion;

public class ProductoElectronico {
    private String nombre;
    private int precio;
    private int stock;
    private Seccion seccion;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public ProductoElectronico(String nombre, int precio, int stock, Seccion seccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.seccion = seccion;
    }

    public ProductoElectronico() {
        this.nombre = "x";
        this.precio= 0;
        this.stock= 0;
        this.seccion= Seccion.CARGADORES;
    }
}
