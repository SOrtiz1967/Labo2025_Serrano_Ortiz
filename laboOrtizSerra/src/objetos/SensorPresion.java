package objetos;

import java.time.LocalDate;

public class SensorPresion extends Dispositivo{

    public SensorPresion(boolean estado, float medida, float umbralInicial, LocalDate añoAdquisicion) {
        super(estado, medida, umbralInicial, añoAdquisicion);

    }
    public void alarma(){
        System.out.println("Sensor de presión activado");
    }

}
