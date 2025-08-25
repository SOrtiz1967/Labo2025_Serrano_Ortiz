package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.util.HashMap;

public abstract class Vivienda {
    //dirección, un código postal y un dueño asignado
    private String direccion;
    private int cp;
    private Dueño dueño;
    private HashMap<Integer,HashMap<String, Consumo>> registro;

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

    public HashMap<Integer, HashMap<String, Consumo>> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, HashMap<String, Consumo>> registro) {
        this.registro = registro;
    }

    public Vivienda(String direccion, int cp, Dueño dueño, HashMap<Integer, HashMap<String, Consumo>> registro) {
        this.direccion = direccion;
        this.cp = cp;
        this.dueño = dueño;
        this.registro = registro;
    }

    public abstract void cargarConsumo(LocalDate fecha, int consumo);


    public abstract double calcularPago();

}
