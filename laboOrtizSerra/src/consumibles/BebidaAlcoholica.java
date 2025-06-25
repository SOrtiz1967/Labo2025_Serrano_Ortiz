package consumibles;

public class BebidaAlcoholica extends Bebida{
    private double cAlcohol;
    private static double coeficientePositividad=0;
    private static double multiplicador=20;

    public BebidaAlcoholica(String nombre, double cAlcohol) {
        super(nombre);
        this.cAlcohol = cAlcohol;
    }
    public BebidaAlcoholica(){
        super("champeta");
        this.cAlcohol=7.6;
    }

    public double getcAlcohol() {
        return cAlcohol;
    }

    public void setcAlcohol(double cAlcohol) {
        this.cAlcohol = cAlcohol;
    }
    public double calcularCoeficienteNegatividad(){
        return this.cAlcohol*multiplicador;
    }
}
