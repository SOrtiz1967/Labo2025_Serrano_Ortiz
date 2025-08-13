package segundoCuatri.Poblacion;

import java.util.HashSet;

public class Provincia extends Lugar{
    private HashSet<Ciudad> ciudades;

    public Provincia(String nombre, int codigo, HashSet<Coordenadas> limite, HashSet<Ciudad> ciudades) {
        super(nombre, codigo, limite);
        this.ciudades = ciudades;
    }
    public Provincia() {
        super("CABA", 8392, new HashSet<Coordenadas>());
        HashSet<Ciudad> citys=new HashSet<>();
        citys.add(new Ciudad());
        this.ciudades = citys;
    }

    public HashSet<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(HashSet<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public int censoPoblacion() {
        int censo=0;
        for (Ciudad c: ciudades){
            censo+=c.censoPoblacion();
        }
        return censo;
    }
}
