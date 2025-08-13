package segundoCuatri.Poblacion;

import java.util.HashSet;

public class Pais extends Lugar{
    private HashSet<Provincia> provincias;

    public Pais(String nombre, int codigo, HashSet<Coordenadas> limite, HashSet<Provincia> provincias) {
        super(nombre, codigo, limite);
        this.provincias = provincias;
    }
    public Pais() {
        super("Arg", 1111111, new HashSet<Coordenadas>());
        HashSet<Provincia> pro = new HashSet<>();
        pro.add(new Provincia());
        this.provincias = pro;
    }


    public HashSet<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(HashSet<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public int censoPoblacion() {
        int censo=0;
        for (Provincia p: provincias){
            censo+=p.censoPoblacion();
        }
        return censo;
    }
}
