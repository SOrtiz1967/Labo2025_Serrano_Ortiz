package EJ1;

import primerCuatri.probar.personas.Persona;
import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Participante extends Persona {
    private HashSet<Ingrediente> ingredientesProhibidos;
    private HashMap<Ingrediente,Integer> stockIngredientes;
    public Participante(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion);
        this.ingredientesProhibidos = ingredientesProhibidos;
        this.stockIngredientes = stockIngredientes;
    }
    public Participante() {
        super();
        this.ingredientesProhibidos = new HashSet<>();
        this.stockIngredientes = new HashMap<>();
    }

    public Participante(String nombre, int edad, String apellido, String direccion) {
        super(nombre, edad, apellido, direccion);
    }


    public HashSet<Ingrediente> getIngredientesProhibidos() {
        return ingredientesProhibidos;
    }

    public void setIngredientesProhibidos(HashSet<Ingrediente> ingredientesProhibidos) {
        this.ingredientesProhibidos = ingredientesProhibidos;
    }

    public HashMap<Ingrediente, Integer> getStockIngredientes() {
        return stockIngredientes;
    }

    public void setStockIngredientes(HashMap<Ingrediente, Integer> stockIngredientes) {
        this.stockIngredientes = stockIngredientes;
    }

    public abstract void mensaje();
}
