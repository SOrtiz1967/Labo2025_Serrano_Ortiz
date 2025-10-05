package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.arcoyflecha.Color;

import java.util.HashMap;
import java.util.HashSet;

public class Principiante extends Participante implements CocinaryservirEntrada {
    private HashSet<Ingrediente> ingredientesProhibidos;

    public Principiante(String nombre, int edad, String apellido, String direccion, Color equipo, HashSet<Ingrediente> ingredientesProhibidos) {
        super(nombre, edad, apellido, direccion,equipo);
        this.ingredientesProhibidos=new HashSet<>();
    }

    public HashSet<Ingrediente> getIngredientesProhibidos() {
        return ingredientesProhibidos;
    }

    public void setIngredientesProhibidos(HashSet<Ingrediente> ingredientesProhibidos) {
        this.ingredientesProhibidos = ingredientesProhibidos;
    }


    public Principiante() {
        super();
        this.ingredientesProhibidos= new HashSet<Ingrediente>();
    }
    @Override
    public void mensaje(){
        System.out.println( "Ya guarde todos los elementos prohibidos y no voy a usar: ");
        for(Ingrediente i:this.getIngredientesProhibidos()){
            System.out.println(i.getNombre());
        }
    }
    @Override
    public boolean cocinarEntrada(PlatoRepaso entrada){
        try{
            for(Ingrediente i : entrada.getIngredientes()){
                if(this.getIngredientesProhibidos().contains(i)){
                    throw new IngredienteProhibidoException("Ingrediente prohibido contenido por el plato entrada");
                }
            }
            return true;
        } catch (IngredienteProhibidoException e) {
            System.err.println(e.getMessage());
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
