package ejercicioAlarmas;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaAlarmas {
    private ArrayList<Dispositivo> sensores;

    public ArrayList<Dispositivo> getSensores() {
        return sensores;
    }

    public void setSensores(ArrayList<Dispositivo> sensores) {
        this.sensores = sensores;
    }
    public String traerInfo(int locuron) throws Exception{
        /*
        try {
            if(locuron>sensores.size() ){
                throw new IllegalArgumentException();
            }
        }
     */
        String Mensaje="el estado de la alarma es "+sensores.get(locuron).estado+" su medida es: "+sensores.get(locuron).medida+"al ritmo ";
        return Mensaje;
    }

    public SistemaAlarmas(ArrayList<Dispositivo> sensores) {
        this.sensores = sensores;
    }
    public void chequear(){
        for (Dispositivo d: sensores){
            d.tomarMedida();
        }
    }

    public static void main(String[] args) {

        ArrayList<Dispositivo> sensores = new ArrayList<>();
        sensores.add(new DetectorHumo(true, 90, 50, LocalDate.now()));
        sensores.add(new SensorTemperatura(true, 80, 75, LocalDate.now()));
        sensores.add(new SensorPresion(true, 60, 65, LocalDate.now()));

        SensorCompuesto compuesto = new SensorCompuesto(
                true,
                0,
                70,
                LocalDate.now(),
                new ArrayList<>(sensores)
        );
        sensores.add(compuesto);

        SistemaAlarmas sistema = new SistemaAlarmas(sensores);
        sistema.chequear();


        try{
            System.out.println(sistema.traerInfo(78));
        }catch (Exception e){
            System.out.println("el numero de sensor que ingresaste non existe: "+e);
        }



        }






}
