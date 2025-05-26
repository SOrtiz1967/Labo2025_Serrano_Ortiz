package objetos;

public class Componente {
    private  String fabricante;
    private String modelo;
    private double precio;
    private int stock;

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Componente(){
        this.fabricante="Agustin Urzi";
        this.modelo="refrigeracion Caniche";
        this.precio=80000;
        this.stock=54;
    }
    public Componente(String fabricante, String modelo, double precio, int stock) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public void ajustarPorInflacion(double porcentaje) {
        this.precio = this.precio * (1 + porcentaje / 100);
    }
    public boolean hayStock(){
        return stock>0;
    }
    public void restarStock(int howmuch){
        if(stock>=howmuch){
            this.stock= stock-howmuch;
        }

    }
    public void sumarStock(int howmuch){
        this.stock=stock + howmuch;
    }

}
