package EJ1;

import primerCuatri.probar.personas.Persona;
import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.arcoyflecha.Color;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Participante extends Persona {
    private Color equipo;
    public Participante(String nombre, int edad, String apellido, String direccion,Color equipo) {
        super(nombre, edad, apellido, direccion);
        this.equipo=equipo;
    }
    public Participante() {
        super();
        this.equipo=Color.AZUL;
    }
    public abstract void mensaje();
}
