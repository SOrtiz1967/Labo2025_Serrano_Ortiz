package objetos;

public class Prenda {

    private String detalles;
    private double costo;
    private static double minPrice = 10.0;
    private static double tax = 1.2;
    private String talla;

    public Prenda(String detalles, double costo, String talla){
        this.detalles = detalles;
        this.costo = costo;
        
        this.talla = talla;
    }
    // no hace falta constructor por defecto 

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getCosto() {
        return costo * tax;
    }
    

    public void setCosto(double costo) {
        if (costo > minPrice){
            this.costo = costo;
        }

    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public static void main(String[] args) {
        // Método main vacío
    }
}
