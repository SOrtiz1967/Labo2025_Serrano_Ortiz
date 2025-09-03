package segundoCuatri.ControlCalorias;

import primerCuatri.probar.personas.Persona;

import java.util.HashMap;
import java.util.Map;

public class MiembroFamiliar extends Persona {
    private HashMap<Plato,Integer> platoconcalorias;

    public MiembroFamiliar(String nombre, int edad, HashMap<Plato, Integer> platoconcalorias) {
        super(nombre, edad);
        this.platoconcalorias = platoconcalorias;
    }

    public MiembroFamiliar() {
        super();
        this.platoconcalorias= new HashMap<>();
    }

    public HashMap<Plato, Integer> getPlatoconcalorias() {
        return platoconcalorias;
    }

    public void setPlatoconcalorias(HashMap<Plato, Integer> platoconcalorias) {
        this.platoconcalorias = platoconcalorias;
    }
    public int cantidadCalorias(){
        int caloriasComidas=0;
        for(Map.Entry<Plato,Integer> p:platoconcalorias.entrySet()){
            caloriasComidas+=p.getValue();
        }
        return caloriasComidas;
    }
}
