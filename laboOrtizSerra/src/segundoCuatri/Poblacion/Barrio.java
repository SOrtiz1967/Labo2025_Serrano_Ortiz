package segundoCuatri.Poblacion;

import java.util.HashSet;

public class Barrio extends Lugar{

   private int poblacion;


    public Barrio(String nombre, int codigo, HashSet<Coordenadas> limite, int poblacion) {
        super(nombre, codigo, limite);
        this.poblacion = poblacion;
    }
    public Barrio() {
        super("isla maciel", 118924, new HashSet<Coordenadas>());
        this.poblacion = 0;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    @Override
    public int censoPoblacion() {
        return poblacion;
    }
}
