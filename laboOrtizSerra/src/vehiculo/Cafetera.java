package vehiculo;

public class Cafetera {
    private int cantidadMaxima;//es estatico? o depende de la cafetera
    private int cantidadActual;

    public Cafetera() {
        this.cantidadActual=0;
        this.cantidadMaxima=1000;
    }

    public Cafetera(int cantidadMaxima) {
        this.setCantidadActual(cantidadMaxima);
    }

    public Cafetera(int cantidadMaxima, int cantidadActual) {
        if(cantidadActual>cantidadMaxima){
            this.setCantidadActual(cantidadMaxima);
        }

    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void llenarCafetera(){
        this.cantidadActual=this.cantidadMaxima;
    }
    public void servirTaza(int capacidad){
        this.cantidadActual-=capacidad;
    }
    public void vaciarCafetera(){
        this.cantidadActual=0;
    }
    public void agregarCafe(int cantidad){
        this.cantidadActual+=cantidad;
    }
}
