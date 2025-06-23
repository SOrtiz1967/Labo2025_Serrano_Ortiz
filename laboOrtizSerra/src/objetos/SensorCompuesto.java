package objetos;

import Tecnologia.Dispositivo;

import java.time.LocalDate;
import java.util.ArrayList;

public class SensorCompuesto extends Dispositivo {
    private ArrayList<Dispositivo> sensores;

    public ArrayList<Dispositivo> getSensores() {
        return sensores;
    }

    public void setSensores(ArrayList<Dispositivo> sensores) {
        this.sensores = sensores;
    }

    public SensorCompuesto(boolean estado, float medida, float umbralInicial, LocalDate añoAdquisicion, ArrayList<Dispositivo> sensores) {
        super(estado, medida, umbralInicial, añoAdquisicion);
        this.sensores = sensores;
    }

    @Override
    public boolean debeActivarAlarma() {
        double suma = 0;
        for (Dispositivo s : sensores) {
            if (s.estado) {
                suma += s.getMedida();
            }
        }
        return (suma / 3) > umbralInicial;
    }

    @Override
    public void Alarma() {
        System.out.println("Alarma del sensor compuesto activada");
    }

    public void tomarMedidas(){
        if (debeActivarAlarma()) {
            Alarma();
        }
    }
}