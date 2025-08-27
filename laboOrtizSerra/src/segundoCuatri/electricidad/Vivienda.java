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
    public abstract int getPrecio();

    public void cargarConsumo(LocalDate fecha, int consumo){
        Consumo cAux= new Consumo(consumo, getPrecio());
        if(getRegistro().containsKey(fecha.getYear())) {
            //si existe el año vemos si existe el mes
            if (getRegistro().get(fecha.getYear()).containsKey(fecha.getMonth())) {
                System.out.println("ya ingresaste este mes");
            } else {//si no existe ese mes en el año lo agregamos

                getRegistro().get(fecha.getYear()).put(fecha.getMonth(), cAux);

            }
        }
        else{//si el año no existe lo agregamos al map, as el mes
            HashMap<Month, Consumo> hasAux= new HashMap<>();
            hasAux.put(fecha.getMonth(),cAux);
            getRegistro().put(fecha.getYear(), hasAux);


        }
    }
    public double calcularSubtotal(LocalDate fecha){
        if (getRegistro().containsKey(fecha.getYear()) && getRegistro().get(fecha.getYear()).containsKey(fecha.getMonth())) {
            return getRegistro().get(fecha.getYear()).get(fecha.getMonth()).getCosto();
        }
        // aca estaria bueno usar lo de los errores por si ese mes no existe
        return 0;
    }
    public double calcularTotal(LocalDate fecha) {

        if (calcularSubtotal(fecha) <= calcularSubtotal(fecha.minusYears(1)) * 0.9) {
            return calcularSubtotal(fecha) - calcularSubtotal(fecha) * 0.05;
        } else {
            return calcularSubtotal(fecha);
        }
    }


}
