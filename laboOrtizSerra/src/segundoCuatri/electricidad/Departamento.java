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

    public static int getPrecio() {
        return precio;
    }

    public static void setPrecio(int precio) {
        Departamento.precio = precio;
    }

    @Override
    public void cargarConsumo(LocalDate fecha, int consumo) {
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



}
