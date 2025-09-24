package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;

import java.util.HashMap;
import java.util.HashSet;

public class Experto extends Participante{
    private static int tiempo=80;

    public Experto(String nombre, int edad, String apellido, String direccion) {
        super(nombre, edad, apellido, direccion);
    }

    public Experto() {
        super();
    }
    @Override
    public void mensaje(){
        System.out.println( "Ya guarde todos los elementos prohibidos y no voy a usar: "+ );
    }


}
