package vehiculo;

import java.time.LocalDate;

public class Coche extends Vehiculo{
    private String patente;
    private double velocidad;
    private Boolean descapotable;
    public Coche( double velocidad, String pate){
        super("FIAT", "palio", "bordo", 4, LocalDate.of(1998, 3, 19));
        this.patente=pate;
        this.velocidad=velocidad;
        this.descapotable=Boolean.FALSE;
    }

    public Coche(){
        super("FIAT", "Cronos", "blanco", 4, LocalDate.of(2001, 7, 9));
        this.velocidad=100;
        this.patente="AA 340 KN";
        this.descapotable=false;
    }


    public double getVelocidad(){
        return velocidad;
    }
    public String getPatente(){return patente;}
    public Boolean getDescapotable(){return descapotable;}

    public void setPatente(String patente){this.patente=patente;}
    public void setDescapotable(Boolean descapotable){this.descapotable= descapotable;}

    public void setColor(String color) {
        this.color = color;
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
