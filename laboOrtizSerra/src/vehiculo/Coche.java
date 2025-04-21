package vehiculo;

public class Coche {
    private String marca;
    private String modelo;
    private String color;

    private double velocidad;

    public Coche(){
        this.marca="Fiat";
        this.modelo="Cronos";
        this.color="Blanco";
        this.velocidad=100;
    }
    public Coche(String marca, String modelo, String color, double velocidad){
        this.marca=marca;
        this.modelo=modelo;
        this.modelo=color;
        this.velocidad=velocidad;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public String getColor(){
        return color;
    }
    public double getVelocidad(){
        return velocidad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void acelerar(){
        velocidad++;
    }
    public void frenar(){
        velocidad--;
    }
    public void mostrarVelocidadActual(){
        System.out.println("La velocidad es: "+ velocidad);
    }
}
