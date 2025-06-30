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
    @java.lang.Override
    public static double traerCoeficientePositividad() {
        return coeficientePositividad;
    }

    public static void setCoeficientePositividad(double coeficientePositividad) {
        BebidaAlcoholica.coeficientePositividad = coeficientePositividad;
    }

    public double getcAlcohol() {
        return cAlcohol;
    }

    public void setcAlcohol(double cAlcohol) {
        this.cAlcohol = cAlcohol;
    }

    @java.lang.Override
    public double calcularCoeficienteNegatividad() {
        return this.cAlcohol*multiplicador;
    }
    //public double calcularCoeficienteNegatividad(){return this.cAlcohol*multiplicador;}
}
