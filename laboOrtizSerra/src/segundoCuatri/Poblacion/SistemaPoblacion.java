package segundoCuatri.Poblacion;

import java.util.HashSet;

public class SistemaPoblacion {
    private HashSet<Continente> continentes;

    public SistemaPoblacion(HashSet<Continente> continentes) {
        this.continentes = continentes;
    }

    public HashSet<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(HashSet<Continente> continentes) {
        this.continentes = continentes;
    }
    public void mostrarInfo(){
        Pais pmas=continentes.iterator().next().getPaises().iterator().next();
        Pais pmenos=continentes.iterator().next().getPaises().iterator().next();
        Continente cmas=continentes.iterator().next();
        Continente cmenos= continentes.iterator().next();

        for (Continente c: continentes){
            if (c.censoPoblacion()>cmas.censoPoblacion()){
                cmas=c;
            }
            else if(c.censoPoblacion()<pmenos.censoPoblacion()){
                cmenos=c;
            }
            for (Pais p: c.getPaises()){
                if (p.censoPoblacion()>pmas.censoPoblacion()){
                    pmas=p;
                }
                else if(p.censoPoblacion()<pmenos.censoPoblacion()){
                    pmenos=p;
                }
            }
        }
        System.out.println("el pais con mas poblacion es: "+ pmas.getNombre()+"el que menos: "+ pmenos.getNombre()+"EL CONTIENTE CON MENOS POBLACION es: "+ cmenos.getNombre()+"el que mas es "+ cmas.getNombre());
    }
}
