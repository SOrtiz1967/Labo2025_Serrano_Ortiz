package segundoCuatri.arcoyflecha;

import java.util.HashMap;
import java.util.HashSet;

public class SistemaTiraFlecha {
    // En nuestro sistema tendremos una lista de bares que implementan el arco y flecha, una lista de
    // todos los tipos de diana y una lista de todos los beneficios que ofrece este juego.
    private HashSet<Bar> establecimientos;
    private HashSet<Diana> dianas;
    private HashSet<Beneficio> beneficios;

    public SistemaTiraFlecha(HashSet<Bar> establecimientos, HashSet<Diana> dianas, HashSet<Beneficio> beneficios) {
        this.establecimientos = establecimientos;
        this.dianas = dianas;
        this.beneficios = beneficios;
    }

    public HashSet<Bar> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(HashSet<Bar> establecimientos) {
        this.establecimientos = establecimientos;
    }

    public HashSet<Diana> getDianas() {
        return dianas;
    }

    public void setDianas(HashSet<Diana> dianas) {
        this.dianas = dianas;
    }

    public HashSet<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(HashSet<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
    // Para cada bar se quiere saber cuántos beneficios de tragos tiene. Es decir, aquellos
    // beneficios no acumulables.
    public void beneficiosTragos(){
        int contador=0;
        //ENTRAR A BAR Y RESTRARLE EL SIZE DE ACUMULABLES AL SIZE DE BENEFICIOS
        for (Bar b: establecimientos){
            contador += b.getBeneficios().size() - b.getBeneficiosAcumulables().size();
            System.out.println("este bar tiene: "+ contador+ "beneficios no acumulables");
        }

    }
    //Retornar la diana de nuestro sistema que tenga más cantidad de puntajes distintos.
    public Diana dianaMasPiola(){
        HashMap<Integer, Color> siquesi=new HashMap<>();
        Diana d= null;
        int aux=0;
        for (Diana d1: dianas){
            //es ineceseario el aux podes calclarlo con cada var
            if(d==null || aux<d1.getPuntaje().keySet().size()){
                aux=d1.getPuntaje().keySet().size();
                d=d1;
            }
        }
        return d;
    }



}
