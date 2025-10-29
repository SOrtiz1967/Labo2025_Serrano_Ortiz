package RepasoRecuperatorio2;

import java.util.HashMap;

public abstract class Preparacion {
    private HashMap<String, Integer> cantidadIngrediente;
    private int stock;
    private double precio;
    private String receta;

    public HashMap<String, Integer> getCantidadIngrediente() {
        return cantidadIngrediente;
    }

    public void setCantidadIngrediente(HashMap<String, Integer> cantidadIngrediente) {
        this.cantidadIngrediente = cantidadIngrediente;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public void sumarStock(int c){
        this.stock+=c;
    }
    public void restarStock(int c){
        this.stock-=c;
    }

    public Preparacion(HashMap<String, Integer> cantidadIngrediente, int stock, double precio, String receta) {
        this.cantidadIngrediente = cantidadIngrediente;
        this.stock = stock;
        this.precio = precio;
        this.receta = receta;
    }

    public Preparacion() {
        this.cantidadIngrediente = new HashMap<>();
        this.stock = 0;
        this.precio = 0;
        this.receta = "";
    }

    public abstract void agregarIngredienteEspecial();

    public abstract String conocerReceta();
}