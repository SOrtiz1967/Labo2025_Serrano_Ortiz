package segundoCuatri.Poblacion;

import java.util.HashSet;

public class Ciudad extends Lugar{
    private HashSet<Barrio> barrios; //un lugar tiene muchos barrios como CASLA

    public HashSet<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(HashSet<Barrio> barrios) {
        this.barrios = barrios;
    }

    public Ciudad(String nombre, int codigo, HashSet<Coordenadas> limite, HashSet<Barrio> barrios) {
        super(nombre, codigo, limite);
        this.barrios = barrios;
    }
    public Ciudad() {
        super("carlos keen", 7932671, new HashSet<Coordenadas>());
        HashSet<Barrio> bb=new HashSet<Barrio>();
        bb.add(new Barrio());
        this.barrios = bb;
    }

    @Override
    public int censoPoblacion() {
        int censo=0;
        for (Barrio b: barrios){
            censo+=b.censoPoblacion();
        }
        return censo;
    }
}
