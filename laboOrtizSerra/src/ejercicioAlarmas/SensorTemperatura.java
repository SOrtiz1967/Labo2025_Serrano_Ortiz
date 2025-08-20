package ejercicioAlarmas;

import java.time.LocalDate;

public class SensorTemperatura extends Dispositivo {
    public SensorTemperatura(boolean estado, float medida, float umbralInicial, LocalDate añoAdquisicion) {
        super(estado, medida, umbralInicial, añoAdquisicion);
    }
    public void Alarma(){

        System.out.print("cuidado la temperatura sube!");



    }
}
