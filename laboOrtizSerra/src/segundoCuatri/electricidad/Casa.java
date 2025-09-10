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
    @Override
    public int getPrecio() {

        return precio;
    }

    public static void setPrecio(int precio) {
        Casa.precio = precio;
    }




}
