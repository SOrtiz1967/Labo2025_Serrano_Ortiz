package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Intermedio extends Participante implements CocinaryservirPrincipal {
    private HashSet<Ingrediente> ingredientesProhibidos;
    private HashMap<Ingrediente,Integer> stockIngredientes;
    public Intermedio(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion, ingredientesProhibidos, stockIngredientes);
    }

    public Intermedio() {
        super();
        this.ingredientesProhibidos=new HashSet<Ingrediente>();
        this.stockIngredientes=new HashMap<Ingrediente, Integer>();
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

    public HashMap<Ingrediente,Integer> getStockIngredientesMayorA1(){
        HashMap<Ingrediente,Integer> mayoresA1=new HashMap<>();
        for(Map.Entry<Ingrediente,Integer> m :this.getStockIngredientes().entrySet()){
            if(m.getValue()>1){
                mayoresA1.put(m.getKey(),m.getValue());
            }
        }
        return mayoresA1;
    }

    @Override
    public void mensaje(){
        System.out.println( "Mi stock a utilizar es de: ");
        for(Map.Entry<Ingrediente,Integer> m: this.getStockIngredientesMayorA1().entrySet()){
            System.out.println("Ingrediente: "+ m.getKey()+ "Cantidad: "+ m.getValue());
        }
    }

    @Override
    public boolean cocinarPrincipal(PlatoRepaso principal){
        try{
            for(Ingrediente i : principal.getIngredientes()){
                if(this.getIngredientesProhibidos().contains(i)){
                    throw new IngredienteProhibidoException("Ingrediente prohibido contenido por el plato principal");
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
    public void servirPrincipal(PlatoRepaso principal){
        if(cocinarPrincipal(principal)){
            System.out.println("El plato principal está servido está servida");
        }
    }

}
