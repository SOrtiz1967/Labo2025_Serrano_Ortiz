package objetos;

import java.time.LocalDate;

public class DetectorHumo extends Dispositivo{
    public DetectorHumo(boolean estado, float medida, float umbralInicial, LocalDate añoAdquisicion) {
        super(estado, medida, umbralInicial, añoAdquisicion);
    }
    @Override
    public void Alarma(){
        System.out.println("llamada a los bomberos exitosa");
    }
}
