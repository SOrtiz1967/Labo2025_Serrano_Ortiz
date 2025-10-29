package RepasoRecuperatorioJava;

import java.util.HashSet;

public class Epica extends Carta{
    private double segundosInactivo;

    public double getSegundosInactivo() {
        return segundosInactivo;
    }

    public void setSegundosInactivo(double segundosInactivo) {
        this.segundosInactivo = segundosInactivo;
    }

    public Epica(String nombre, double danio, double vida, Arena arenaDesbloqueo, double segundosInactivo) {
        super(nombre, danio, vida, arenaDesbloqueo);
        this.segundosInactivo = segundosInactivo;
    }

    public Epica() {
        super();
        this.segundosInactivo = 0;
    }

    @Override
    public void frase(){
        System.out.println("soy una carta épica, me jugaron y me desbloqueo en: "+this.segundosInactivo);
    }
    public HashSet<Double> valoresAtributos(){
        HashSet<Double> valoresAtributos= new HashSet<>();
        valoresAtributos.add(this.segundosInactivo);
        valoresAtributos.add(this.getDanio());
        valoresAtributos.add(this.getVida());
        return valoresAtributos;
    }
}
