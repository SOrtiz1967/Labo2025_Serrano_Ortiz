package objetos;

import java.util.ArrayList;

public class Salida extends Componente{
    //pantallas e impresoras (puertos; para impresoras, método de impresión: inyección o láser)
    private ArrayList<String> puertos;


    public Salida(String fabricante, String modelo, double precio, int stock, ArrayList<String> puertos) {
        super(fabricante, modelo, precio, stock);
        this.puertos = puertos;
    }

    public ArrayList<String> getPuertos() {
        return puertos;
    }

    public void setPuertos(ArrayList<String> puertos) {
        this.puertos = puertos;
    }
}
