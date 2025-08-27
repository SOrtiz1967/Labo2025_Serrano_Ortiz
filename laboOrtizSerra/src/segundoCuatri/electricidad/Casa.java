package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class Casa extends Vivienda{
    //Si la vivienda es una casa, se guardarán los metros cubiertos por un lado y los descubiertos por otro.
    // En cambio, si es un departamento se guarda la cantidad de ambientes.
    private int mCubiertos;
    private int mDescubiertos;
    private static int precio=100;

    public Casa(String direccion, int cp, Dueño dueño, HashMap<Integer, HashMap<Month, Consumo>> registro, int mCubiertos, int mDescubiertos) {
        super(direccion, cp, dueño, registro);
        this.mCubiertos = mCubiertos;
        this.mDescubiertos = mDescubiertos;
    }

    public int getmCubiertos() {
        return mCubiertos;
    }

    public void setmCubiertos(int mCubiertos) {
        this.mCubiertos = mCubiertos;
    }

    public int getmDescubiertos() {
        return mDescubiertos;
    }

    public void setmDescubiertos(int mDescubiertos) {
        this.mDescubiertos = mDescubiertos;
    }

    public static int getPrecio() {
        return precio;
    }

    public static void setPrecio(int precio) {
        Casa.precio = precio;
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
