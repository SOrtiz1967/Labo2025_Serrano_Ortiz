package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.ControlCalorias.Plato;
import segundoCuatri.arcoyflecha.Color;

import java.time.LocalDate;
import java.util.HashSet;

public class PlatoRepaso extends Plato {
    private int tiempoCoccion;

    public PlatoRepaso(String nombre, HashSet<Ingrediente>ingredientes,int calorias, int tiempoCoccion) {
        super(nombre,ingredientes,calorias);
        this.tiempoCoccion=tiempoCoccion;
    }

    public PlatoRepaso() {
        super();
        this.tiempoCoccion=0;
    }
    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }
}
