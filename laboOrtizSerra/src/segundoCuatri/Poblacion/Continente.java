package segundoCuatri.Poblacion;

import java.util.HashSet;

public class Continente extends Lugar{
    private HashSet<Pais> paises;

    public Continente(String nombre, int codigo, HashSet<Coordenadas> limite, HashSet<Pais> paises) {
        super(nombre, codigo, limite);
        this.paises = paises;
    }
    public Continente() {
        super("America", 4, new HashSet<Coordenadas>());
        HashSet<Pais> p= new HashSet<Pais>();
        p.add(new Pais());
        this.paises = p;
    }


    public HashSet<Pais> getPaises() {
        return paises;
    }

    public void setPaises(HashSet<Pais> paises) {
        this.paises = paises;
    }

    @Override
    public int censoPoblacion() {
        int censo=0;
        for (Pais p: paises){
            censo+=p.censoPoblacion();
        }
        return censo;
    }
}
