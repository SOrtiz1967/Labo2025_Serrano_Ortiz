package vehiculo;

import java.time.LocalDate;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String color;
    protected int cRuedas;
    protected LocalDate anioFabricacion;

    public Vehiculo(String marca, String modelo, String color, int cRuedas, LocalDate anioFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cRuedas = cRuedas;
        this.anioFabricacion = anioFabricacion;
    }
    public Vehiculo() {
        this.marca ="ford";
        this.modelo = "falcon";
        this.color = "verde";
        this.cRuedas = 4;
        this.anioFabricacion = LocalDate.of(1975,8,2 );
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setcRuedas(int cRuedas) {
        this.cRuedas = cRuedas;
    }

    public void setAnioFabricacion(LocalDate anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getcRuedas() {
        return cRuedas;
    }

    public LocalDate getAnioFabricacion() {
        return anioFabricacion;
    }
}
