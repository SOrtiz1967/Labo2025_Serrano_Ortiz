package vehiculo;

import Estados.EstadoDron;

import java.time.LocalDate;

public class Vigilante extends Dron{
    private int memoriaSD;//(MB)
    private int almacenamientoMaximo;//(MB)

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
    public boolean realizarMision(double longitud, double latitud) {
        double distancia= calcularDistancia(latitud, longitud);
        if (PuedeRealizarMision(distancia)){
            for (int i = 0; i<= distancia; i++){
                if(i%2==0){
                    memoriaSD+=12;
                }

            }
            return true;
        }
        else {
            System.out.println("no se puede realizar la mision, no hay almcenamiento suficiente");
            return false;
        }
    }

    @Override
    public boolean PuedeRealizarMision(double distancia) {
        //pongo un tamaño maximo de bateria yo como atributo
        //cada 2km una foto que ocupa 12mb
        int memoAux=this.memoriaSD;
        for (int i = 0; i<= distancia; i++){
            if(i%2==0){
                memoAux+=12;
            }
        }
        return memoAux <= this.almacenamientoMaximo;
    }

}
