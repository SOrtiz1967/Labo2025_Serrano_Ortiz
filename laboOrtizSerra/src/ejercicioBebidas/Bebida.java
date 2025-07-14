package ejercicioBebidas;

public abstract class Bebida {
    private String nombre;
    // private double coeficiente_positividad; no se decclara aca, por que no podemos sobreescribirlo como static en sus hijas
    //el coeficiente de negatividad se calcula como si fuera el perimetro.


    public Bebida(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public abstract double traerCoeficientepositividad();
    public abstract double calcularCoeficienteNegatividad();
}
