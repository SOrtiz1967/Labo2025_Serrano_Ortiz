package Mascotas;

import personas.Persona;

public class PajaroCantor extends Mascota {
    private String canto;

    public PajaroCantor(String nombre, Persona duenio, String canto) {
        super(nombre, duenio);
        this.canto = canto;
    }
    public String Saludo(){
        return this.canto;
    }
}
