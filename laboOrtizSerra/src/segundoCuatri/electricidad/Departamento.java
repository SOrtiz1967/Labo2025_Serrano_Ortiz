package segundoCuatri.electricidad;

public class Departamento extends Vivienda{
    //Si la vivienda es una casa, se guardarán los metros cubiertos por un lado y los descubiertos por otro.
    // En cambio, si es un departamento se guarda la cantidad de ambientes.
    private int cAmbientes;
    //Para departamentos: $50 el KWh
    private static int precio=50;

    public Departamento(int cAmbientes) {
        this.cAmbientes = cAmbientes;
    }

    public int getcAmbientes() {
        return cAmbientes;
    }

    public void setcAmbientes(int cAmbientes) {
        this.cAmbientes = cAmbientes;
    }

    public static int getPrecio() {
        return precio;
    }

    public static void setPrecio(int precio) {
        Departamento.precio = precio;
    }

    @Override
    public double calcularPago() {

        return ;
    }
}
