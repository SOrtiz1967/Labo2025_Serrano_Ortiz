package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public abstract class Vivienda {
    //dirección, un código postal y un dueño asignado
    private String direccion;
    private int cp;
    private Dueño dueño;
    private HashMap<Integer,HashMap<Month, Consumo>> registro;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public HashMap<Integer, HashMap<Month, Consumo>> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, HashMap<Month, Consumo>> registro) {
        this.registro = registro;
    }

    public Vivienda(String direccion, int cp, Dueño dueño, HashMap<Integer, HashMap<Month, Consumo>> registro) {
        this.direccion = direccion;
        this.cp = cp;
        this.dueño = dueño;
        this.registro = registro;
    }

    public abstract void cargarConsumo(LocalDate fecha, int consumo);


    public double calcularSubtotal(LocalDate fecha){
        if (getRegistro().containsKey(fecha.getYear()) && getRegistro().get(fecha.getYear()).containsKey(fecha.getMonth())) {
            return getRegistro().get(fecha.getYear()).get(fecha.getMonth()).getCosto();
        }
        // aca estaria bueno usar lo de los errores por si ese mes no existe
        return 0;
    }
    public double calcularTotal(LocalDate fecha) {
        //Por otro lado, si el consumo del mes se redujo un 10% respecto del consumo del mismo
        //mes del año anterior se debe aplicar un descuento del 5% al número final.
        if (calcularSubtotal(fecha) <= calcularSubtotal(fecha.minusYears(1)) * 0.9) {
            return calcularSubtotal(fecha) - calcularSubtotal(fecha) * 0.05;
        } else {
            return calcularSubtotal(fecha);
        }
    }


}
