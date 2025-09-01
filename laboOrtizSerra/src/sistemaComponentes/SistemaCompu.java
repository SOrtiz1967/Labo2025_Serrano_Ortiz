package sistemaComponentes;

import java.util.ArrayList;

public class SistemaCompu {

    private ArrayList<CompraProductosInformaticos> computadorasVendidas;

    public SistemaCompu(ArrayList<CompraProductosInformaticos> computadorasVendidas) {
        this.computadorasVendidas = computadorasVendidas;
    }
    public SistemaCompu() {
        this.computadorasVendidas = new ArrayList<>();
    }

    public ArrayList<CompraProductosInformaticos> getComputadorasVendidas() {
        return computadorasVendidas;
    }

    public void setComputadorasVendidas(ArrayList<CompraProductosInformaticos> computadorasVendidas) {
        this.computadorasVendidas = computadorasVendidas;
    }

    public void agregarVenta(CompraProductosInformaticos v){
        computadorasVendidas.add(v);
    }

}