package segundoCuatri.arcoyflecha;

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
    }
}
