package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public class Principiante extends Participante implements CocinaryservirEntrada {
    public Principiante(String nombre, int edad, String apellido, String direccion, HashSet<Ingrediente> ingredientesProhibidos, HashMap<Ingrediente, Integer> stockIngredientes) {
        super(nombre, edad, apellido, direccion, ingredientesProhibidos, stockIngredientes);
    }

    public Principiante() {
        super();
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
