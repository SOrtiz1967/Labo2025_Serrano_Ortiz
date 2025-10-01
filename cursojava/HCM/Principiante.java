package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public class Principiante extends Participante implements CocinaryservirEntrada {
    private HashSet<Ingrediente> ingredientesProhibidos;
    private HashMap<Ingrediente,Integer> stockIngredientes;
    public Principiante(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion, ingredientesProhibidos, stockIngredientes);
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

    public Principiante() {
        super();
        this.ingredientesProhibidos= new HashSet<Ingrediente>();
        this.stockIngredientes= new HashMap<Ingrediente, Integer>();
    }
    @Override
    public void mensaje(){
        System.out.println( "Ya guarde todos los elementos prohibidos y no voy a usar: ");
        for(Ingrediente i:this.getIngredientesProhibidos()){
            System.out.println(i);
        }
    }
    @Override
    public boolean cocinarEntrada(PlatoRepaso entrada){
        try{
            for(Ingrediente i : entrada.getIngredientes()){
                if(this.getIngredientesProhibidos().contains(i)){
                    throw new IngredienteProhibidoException("Ingrediente prohibido contenido por el plato entrada");
                }
                if(this.getStockIngredientes().containsKey(i)&&this.getStockIngredientes().get(i)<=0){
                    throw new NohayStockIngrediente("Ingrediente sin stock");
                }
            }
            return true;
        } catch (IngredienteProhibidoException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (NohayStockIngrediente f) {
            System.err.println(f.getMessage());
            return false;
        }
    }
    @Override
    public void servirEntrada(PlatoRepaso entrada){
        if(cocinarEntrada(entrada)){
            System.out.println("La entrada está servida");
        }
    }
}
