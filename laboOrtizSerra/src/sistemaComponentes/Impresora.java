package sistemaComponentes;

import java.util.ArrayList;

public class Impresora extends Salida {
    private String metodo;

    public Impresora(String fabricante, String modelo, double precio, int stock, ArrayList<String> puertos, String metodo) {
        super(fabricante, modelo, precio, stock, puertos);
        this.metodo=metodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
