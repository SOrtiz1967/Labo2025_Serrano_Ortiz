package vehiculo;

public class Delivery extends Dron{

    private double carga;
    @Override
    public boolean realizarMision(double longitud, double latitud) {
        double distancia=calcularDistancia(longitud, latitud);
        if (PuedeRealizarMision(distancia)){
            int auxbate=getBateria()-50;
            setBateria(auxbate);
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean PuedeRealizarMision(double distancia) {
        int auxbate=this.getBateria();
        if(distancia<=30){
            if(auxbate>50){
                return true;
            }
            else{
                return false;
            }
        }
        return false;


    }

}
