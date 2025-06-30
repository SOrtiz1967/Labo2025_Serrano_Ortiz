package personas;

import auxiliares.Consumicion;
import consumibles.Bebida;

import java.util.ArrayList;

public class Tomador extends Persona{
    private int dni;
    private ArrayList<Consumicion> consumos;

    public Tomador(int dni, ArrayList<Consumicion> consumos) {
        this.dni = dni;
        this.consumos = consumos;
    }

    public Tomador(String nombre, int edad, String apellido, String direccion, int dni, ArrayList<Consumicion> consumos) {
        super(nombre, edad, apellido, direccion);
        this.dni = dni;
        this.consumos = consumos;
    }

    public Tomador(String nombre, int edad, int dni, ArrayList<Consumicion> consumos) {
        super(nombre, edad);
        this.dni = dni;
        this.consumos = consumos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ArrayList<Consumicion> getConsumos() {
        return consumos;
    }

    public void setConsumos(ArrayList<Consumicion> consumos) {
        this.consumos = consumos;
    }
    public void registrarConsumo(Bebida bebida1, int cantidad){
        consumos.add(new Consumicion(bebida1, cantidad));
    }
    public double calcularCoeficienteHidratacion() {
        double total = 0;
        for (Consumicion c : consumos) {
            double coefPos = c.getBebida().traerCoeficientepositividad();
            double coefNeg = c.getBebida().calcularCoeficienteNegatividad();
            total += c.getCantidad() * (coefPos - coefNeg);
        }
        return total;
    }

}
