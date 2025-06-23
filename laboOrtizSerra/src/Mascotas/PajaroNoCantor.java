package Mascotas;

import personas.Persona;

public class PajaroNoCantor extends Mascota{

    public PajaroNoCantor(String nombre, Persona duenio) {
        super(nombre, duenio);

    }

    public PajaroNoCantor() {
        super();
    }

    @Override
    public String Saludo(){
        return "pio";}
}
