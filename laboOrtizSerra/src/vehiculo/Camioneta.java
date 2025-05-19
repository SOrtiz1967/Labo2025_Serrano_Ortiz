package vehiculo;

import java.time.LocalDate;

public class Camioneta extends Vehiculo {
    private String patente;
    private int carga;
    private int cagaMax;

    public Camioneta(String marca, String modelo, String color, int cRuedas, LocalDate anioFabricacion, String patente, int carga, int cagaMax) {
        super(marca, modelo, color, cRuedas, anioFabricacion);
        this.patente = patente;
        this.carga = carga;
        this.cagaMax=cagaMax;
    }
    public Camioneta(){
        super();
        this.patente="AA 984 HT";
        this.carga=50;
        this.cagaMax=80;
    }

    public Camioneta(String patente, int carga) {
        this.patente = patente;
        this.carga = carga;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
    public void añadirCarga(int carga){
        if (this.carga+carga >this.cagaMax){
            System.out.println("exediste el limite de peso");
        }
        else{
            this.carga+=carga;
            System.out.println("se añadio la carga correctamente");
        }
    }
}
