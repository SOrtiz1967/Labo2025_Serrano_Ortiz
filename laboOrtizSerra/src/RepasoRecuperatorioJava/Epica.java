package RepasoRecuperatorioJava;

public class Epica extends Carta{
    private double segundosInactivo;
    @Override
    public void frase(){
        System.out.println("soy una carta épica, me jugaron y me desbloqueo en: "+this.segundosInactivo);
    }
}
