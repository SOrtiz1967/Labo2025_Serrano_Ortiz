public class Componente {
    private  String fabricante;
    private String modelo;
    private double precio;
    private int stock;
    public Componente(){
        this.fabricante="Agustin Urzi";
        this.modelo="refrigeracion Caniche"
        this.precio=80000;
        this.stock=54;
    }
    public Componente(String fabricante, String modelo, double precio, int stock) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public void ajustarPrecioPorInflacion(double porcentaje) {
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
