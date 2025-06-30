package consumibles;

public class BebidaNeutra extends Bebida {
    private double coeficientePositividad;
    private double coeficienteNegatividad;

    public BebidaNeutra(String nombre, double coeficientePositividad, double coeficienteNegatividad) {
        super(nombre);
        this.coeficientePositividad = coeficientePositividad;
        this.coeficienteNegatividad = coeficienteNegatividad;
    }
    public BebidaNeutra(){
        super("VillaManaos");
        this.coeficienteNegatividad=30.0;
        this.coeficientePositividad=20.0;
    }
    @java.lang.Override
    public double traerCoeficientePositividad() {
        return coeficientePositividad;
    }

    public void setCoeficientePositividad(double coeficientePositividad) {
        this.coeficientePositividad = coeficientePositividad;
    }


    @java.lang.Override
    public double calcularCoeficienteNegatividad() {
        return this.coeficienteNegatividad;
    }

    public void setCoeficienteNegatividad(double coeficienteNegatividad) {
        this.coeficienteNegatividad = coeficienteNegatividad;
    }
}
