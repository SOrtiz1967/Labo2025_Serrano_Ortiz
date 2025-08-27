package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class Departamento extends Vivienda{
    //Si la vivienda es una casa, se guardarán los metros cubiertos por un lado y los descubiertos por otro.
    // En cambio, si es un departamento se guarda la cantidad de ambientes.
    private int cAmbientes;
    //Para departamentos: $50 el KWh
    private static int precio=50;

    public Departamento(String direccion, int cp, Dueño dueño, HashMap<Integer, HashMap<Month, Consumo>> registro, int cAmbientes) {
        super(direccion, cp, dueño, registro);
        this.cAmbientes = cAmbientes;
    }

    public int getcAmbientes() {
        return cAmbientes;
    }

    public void setcAmbientes(int cAmbientes) {
        this.cAmbientes = cAmbientes;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    public static void setPrecio(int precio) {
        Departamento.precio = precio;
    }





}
