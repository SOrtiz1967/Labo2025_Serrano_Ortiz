package sistemas;

import consumibles.Bebida;
import personas.Tomador;

public class SistemaTomadores {
    private ArrayList<Tomador> tomadores;
    private ArrayList<Bebida> bebidas;

    public SistemaBebidas() {
        this.tomadores = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }

    public void agregarTomador(Tomador t) {
        tomadores.add(t);
    }

    public void agregarBebida(Bebida b) {
        bebidas.add(b);
    }

}
