package vehiculo;

import Estados.EstadoDron;

import java.time.LocalDate;

public class Vigilante extends Dron{
    private int memoriaSD;
    private int almacenamientoMaximo;

    public int getMemoriaSD() {
        return memoriaSD;
    }

    public void setMemoriaSD(int memoriaSD) {
        this.memoriaSD = memoriaSD;
    }

    public int getAlmacenamientoMaximo() {
        return almacenamientoMaximo;
    }

    public void setAlmacenamientoMaximo(int almacenamientoMaximo) {
        this.almacenamientoMaximo = almacenamientoMaximo;
    }

    public Vigilante(String nModelo, LocalDate fAdqisicion, EstadoDron estado, int bateria, int memoriaSD, int almacenamientoMaximo) {
        super(nModelo, fAdqisicion, estado, bateria);
        this.memoriaSD = memoriaSD;
        this.memoriaSD=almacenamientoMaximo;
    }
    public Vigilante(){
        super();
        this.memoriaSD= 6;
        this.memoriaSD=100;
    }

    public Vigilante(int memoriaSD) {
        this.memoriaSD = memoriaSD;
    }

    @Override
    public boolean realizarMision(int longitud, int latitud) {
        double distancia= calcularDistancia(latitud, longitud);
        if (PuedeRealizarMision(distancia)){

        }
        else {
            return false;
        }
    }

    @Override
    public boolean PuedeRealizarMision(double distancia) {
        //pongo un tamaño maximo de bateria yo como atributo
    }
}
