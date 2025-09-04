package segundoCuatri.sistemaComponentes;

import java.util.ArrayList;

public class Entrada extends Componente {
    //teclado y mouse (tipo de conector y puertos)
    private String conector;
    private ArrayList<String> puertos;



    public Entrada(String fabricante, String modelo, double precio, int stock, String conector, ArrayList<String> puertos) {
        super(fabricante, modelo, precio, stock);
        this.conector = conector;
        this.puertos = puertos;
    }

    public Entrada(){
        super();
        this.conector="USB TIPO Ñ";
        this.puertos= new ArrayList<>();
    }

    public String getConector() {
        return conector;
    }

    public void setConector(String conector) {
        this.conector = conector;
    }

    public ArrayList<String> getPuertos() {
        return puertos;
    }

    public void setPuertos(ArrayList<String> puertos) {
        this.puertos = puertos;
    }
}
