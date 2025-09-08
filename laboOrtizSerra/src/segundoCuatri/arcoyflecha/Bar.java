package segundoCuatri.arcoyflecha;

import java.util.HashSet;

public class Bar {
    // De cada bar se guardará una lista de las dianas que utiliza, la cantidad de clientes que juegan
    // al arco y flecha, el dinero recaudado, una lista de todos los beneficios que decide implementar y
    // una lista de sólo los beneficios acumulables.
    private HashSet<Diana> dianas;
    private int jugadores;
    private double plata;
    private HashSet<Beneficio> beneficios;
    private HashSet<Acumulable> beneficiosAcumulables;

    public Bar(HashSet<Diana> dianas, int jugadores, double plata, HashSet<Beneficio> beneficios, HashSet<Acumulable> beneficiosAcumulables) {
        this.dianas = dianas;
        this.jugadores = jugadores;
        this.plata = plata;
        this.beneficios = beneficios;
        this.beneficiosAcumulables = beneficiosAcumulables;
    }

    public HashSet<Diana> getDianas() {
        return dianas;
    }

    public void setDianas(HashSet<Diana> dianas) {
        this.dianas = dianas;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public HashSet<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(HashSet<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public HashSet<Acumulable> getBeneficiosAcumulables() {
        return beneficiosAcumulables;
    }

    public void setBeneficiosAcumulables(HashSet<Acumulable> beneficiosAcumulables) {
        this.beneficiosAcumulables = beneficiosAcumulables;
    }
}
