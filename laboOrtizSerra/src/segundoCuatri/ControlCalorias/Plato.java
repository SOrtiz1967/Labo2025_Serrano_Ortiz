package segundoCuatri.ControlCalorias;

import java.util.ArrayList;
import java.util.HashSet;

public class Plato {
    private String nombre;
    private HashSet<Ingrediente> ingredientes;
    private int calorias;

    public Plato(String nombre, HashSet<Ingrediente> ingredientes, int calorias) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.calorias = calorias;
    }

    public Plato() {
        this.nombre= "Ravioles a la Bolognesa";
        this.ingredientes= new HashSet<>();
        this.calorias=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashSet<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    /*public void agregarIngrediente(String ingrediente){
        this.ingredientes.add(ingrediente);
    }
    public void eliminarIngrediente(String ingrediente){
        this.ingredientes.remove(ingrediente);
    }
    public void ModificarIngrediente(String ingredienteAPoner, String ingredienteASacar){
        agregarIngrediente(ingredienteAPoner);
        eliminarIngrediente(ingredienteASacar);
    }*/


}
