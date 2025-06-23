package Mascotas;

import personas.Persona;

public abstract class Mascota {
    private String nombre;
    private Persona duenio;

    public Mascota(String nombre, Persona duenio) {
        this.nombre = nombre;
        this.duenio = duenio;
    }

    public Mascota() {
        this.nombre = "";
        this.duenio = new Persona();
    }

    public abstract String Saludo();
    public 
}
