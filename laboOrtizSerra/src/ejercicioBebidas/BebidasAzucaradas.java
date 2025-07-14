package ejercicioBebidas;

public class BebidasAzucaradas extends Bebida {
    private int azucares;//g
    private static double coeficientePositividad=1;
    private static double multiplicador=10;

    public BebidasAzucaradas(String nombre, int azucares) {
        super(nombre);
        this.azucares = azucares;
    }
    public BebidasAzucaradas(){
        super("coto-cola");
        this.azucares=300;
    }

    public int getAzucares() {
        return azucares;
    }

    public void setAzucares(int azucares) {
        this.azucares = azucares;
    }



    public static void setCoeficientePositividad(double coeficientePositividad) {
        BebidasAzucaradas.coeficientePositividad = coeficientePositividad;
    }

    public static double getMultiplicador() {
        return multiplicador;
    }

    public static void setMultiplicador(double multiplicador) {
        BebidasAzucaradas.multiplicador = multiplicador;
    }

    @Override
    public double traerCoeficientepositividad() {
        return coeficientePositividad;
    }

    @Override
    public double calcularCoeficienteNegatividad() {
        return this.azucares*multiplicador;
    }
    // public double calcularCoeficienteNegatividad(){return this.azucares*multiplicador;}
}
