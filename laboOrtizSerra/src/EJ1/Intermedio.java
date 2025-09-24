package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public class Intermedio extends Participante implements AccionesParticipante{

    public Intermedio(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion, ingredientesProhibidos, stockIngredientes);
    }

    public Intermedio() {
        super();
    }

    @Override
}
