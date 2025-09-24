package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public class Principiante extends Participante implements AccionesParticipante{
    public Principiante(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion, ingredientesProhibidos, stockIngredientes);
    }

    public Principiante() {
        super();
    }
    @Override
    public void mensaje(){
        System.out.println( "Ya guarde todos los elementos prohibidos y no voy a usar: "+ getIngredientesProhibidos().);
    }
}
