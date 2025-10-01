package EJ1;

import primerCuatri.probar.personas.Persona;
import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Participante extends Persona {
    public Participante(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion);
        this.ingredientesProhibidos = ingredientesProhibidos;
        this.stockIngredientes = stockIngredientes;
    }
    public Participante() {
        super();
    }

    public Participante(String nombre, int edad, String apellido, String direccion) {
        super(nombre, edad, apellido, direccion);
    }
    public abstract void mensaje();
}
