package objetos;

import java.util.ArrayList;

public class RecetaPlatoPrincipal extends Receta {
    private int tiempoDeCoccion;
    private int numeroComensales;

    public RecetaPlatoPrincipal(String nombre, Dificultad dificultad, ArrayList<String> listadepasos, int tiempoDeCoccion, int numeroComensales) {
        super(nombre, dificultad, listadepasos);
        this.tiempoDeCoccion = tiempoDeCoccion;
        this.numeroComensales = numeroComensales;
    }

    public RecetaPlatoPrincipal() {
        super();
        this.tiempoDeCoccion = 0;
        this.numeroComensales = 0;
    }

    public RecetaPlatoPrincipal(int tiempoDeCoccion, int numeroComensales) {
        this.tiempoDeCoccion = tiempoDeCoccion;
        this.numeroComensales = numeroComensales;
    }

    public int getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(int tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    @Override
    void MostrarReceta() {
        System.out.println("Los pasos a seguir son: ");
        int i = 0;
        for (String paso : super.getListadepasos()) {
            System.out.println("Paso" + i + ":" + paso);
            i++;
        }
    }
}