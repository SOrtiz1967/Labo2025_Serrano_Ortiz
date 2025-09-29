package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.ControlCalorias.Plato;
import segundoCuatri.arcoyflecha.Color;

import java.time.LocalDate;
import java.util.HashSet;

public class PlatoRepaso extends Plato {
    private LocalDate fechaN;
    private String localidad;
    private Color colorPlato;
    private int tiempoCoccion;

    public PlatoRepaso(String nombre, HashSet<Ingrediente>ingredientes,int calorias, String apellido, LocalDate fechaN, String localidad, Color colorPlato, int tiempoCoccion) {
        super(nombre,ingredientes,calorias);
        this.fechaN = fechaN;
        this.localidad = localidad;
        this.colorPlato = colorPlato;
        this.tiempoCoccion=tiempoCoccion;
    }

    public PlatoRepaso() {
        super();
        this.fechaN = LocalDate.of(0,0,0);
        this.localidad = "";
        this.colorPlato = Color.ROJO;
        this.tiempoCoccion=0;
    }
    public LocalDate getFechaN() {
        return fechaN;
    }

    public void setFechaN(LocalDate fechaN) {
        this.fechaN = fechaN;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Color getColorPlato() {
        return colorPlato;
    }

    public void setColorPlato(Color colorPlato) {
        this.colorPlato = colorPlato;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }
}
