package vehiculo;

import Estados.EstadoDron;

import java.time.LocalDate;

public abstract class Dron {
    /*
    nombre de modelo, fecha de adquisición, nivel de carga y un contador que refleja cuántos drones
    operativos hay. Además, este número servirá como id de cada drone para rastrearlo si su estado es en
    vuelo o en operativo. En cambio, si el estado es inactivo o mantenimiento no se podrán rastrear
    (tener en cuenta que los únicos estados del drone van a ser estos, no hay más) Todos los drones podrán
    recargar la batería: donde se asume que cada vez que se recarga se aumenta un 10%. Si la batería estaba
    por debajo del 20% cuando se quiere recargar, entonces va a 100%.
     */
    // con un metodo static hay que aumentar uno la var static para que sirva como id, es decir no se repita!
    private String nModelo;
    private LocalDate fAdqisicion;
    private EstadoDron estado;
    private int bateria;
    private static double latitudOrigen=-34.573195;
    private static double longitudOrigen=-58.504111;
    private static int enOperacion=0;//va a ser unico en cada objeto por que caa vez que se cree uno s va a aumentr

    public Dron(String nModelo, LocalDate fAdqisicion, EstadoDron estado, int bateria) {
        this.nModelo = nModelo;
        this.fAdqisicion = fAdqisicion;
        this.estado = estado;
        this.bateria = bateria;
    }

    public Dron(){
        this.nModelo = "Piovi-x23/11";
        this.fAdqisicion = LocalDate.of(2024,11,23);
        this.estado = EstadoDron.ENVUELO;
        this.bateria=100;
    }
    public abstract boolean realizarMision(int longitud, int latitud);
    public abstract boolean PuedeRealizarMision(int distancia);
    public double calcularDistancia(double latitudDestino, double longitudDestino){
        // Convertir a radianes
        double lat1Rad = Math.toRadians(latitudOrigen);
        double lon1Rad = Math.toRadians(longitudOrigen);
        double lat2Rad = Math.toRadians(latitudDestino);
        double lon2Rad = Math.toRadians(longitudDestino);

// Fórmula de Haversine
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radioTierraKm = 6371;
        return radioTierraKm * c;
    }


   public static void incrementarDron(){
        Dron.enOperacion+=1;
   }

    public String getnModelo() {
        return nModelo;
    }

    public void setnModelo(String nModelo) {
        this.nModelo = nModelo;
    }

    public LocalDate getfAdqisicion() {
        return fAdqisicion;
    }

    public void setfAdqisicion(LocalDate fAdqisicion) {
        this.fAdqisicion = fAdqisicion;
    }

    public EstadoDron getEstado() {
        return estado;
    }

    public void setEstado(EstadoDron estado) {
        this.estado = estado;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public static int getEnOperacion() {
        return enOperacion;
    }

    public static void setEnOperacion(int enOperacion) {
        Dron.enOperacion = enOperacion;
    }
}
