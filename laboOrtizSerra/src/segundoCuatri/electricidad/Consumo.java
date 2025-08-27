package segundoCuatri.electricidad;

public class Consumo {
    private int consumo;
    private int precio;//va a ser precio por kw

    public Consumo(int consumo, int precio) {
        this.consumo = consumo;
        this.precio = precio;
    }
    public double getCosto(){
        double maravilla=consumo*precio;
        return maravilla;
    }
    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
