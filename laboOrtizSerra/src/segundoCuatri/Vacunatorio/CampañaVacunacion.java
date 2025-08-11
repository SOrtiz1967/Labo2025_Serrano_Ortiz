package segundoCuatri.Vacunatorio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CampañaVacunacion {
    private HashMap<Ciudadano, HashSet<Vacuna>> registro;
    private HashMap<Integer, Ciudadano> ciudadanos;

    public HashMap<Ciudadano, HashSet<Vacuna>> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Ciudadano, HashSet<Vacuna>> registro) {
        this.registro = registro;
    }

    public HashMap<Integer, Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(HashMap<Integer, Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public CampañaVacunacion(HashMap<Ciudadano, HashSet<Vacuna>> registro, HashMap<Integer, Ciudadano> ciudadanos) {
        this.registro = registro;
        this.ciudadanos = ciudadanos;
    }
    /*
    Registrar una vacuna aplicada a un ciudadano.
    Consultar el historial de vacunas de un ciudadano por dni.
    Obtener cuantas personas fueron vacunadas por Provincia
    Saber qué ciudadanos cumplen con tener una determinada cantidad de vacunas pasada por parametro.
    Conocer dado una vacuna determinada qué ciudadanos ya se la dieron.
    */
    public void registrarVacuna(Ciudadano c, Vacuna v){
        /*primero chequear si existe*/
        if (registro.containsKey(c)){
            /* probar!!!
            HashSet<Vacuna> vacunas=registro.get(c);
            vacunas.add(v);
             */
            registro.get(c).add(v);

        }
        else{
            HashSet<Vacuna> vacunas=new HashSet<>();
            vacunas.add(v);

            registro.put(c, vacunas);
        }

    }
    public void historialPorDni(int dni){
        if (ciudadanos.containsKey(dni)){
            //mostrar todas las vacunas que tiene este chad
            System.out.println("estas vacunas tiene");
            for (Vacuna v: registro.get(ciudadanos.get(dni))){
                System.out.println(v.getNombreComercial()+ ", ");
            }
        }
        else{
            System.out.println("no existe este ciudadano, no existe :(");
        }

    }
    //personas vacunadas por provincia
    public void vacunadosPorProvincia() {
        HashMap<String, Integer> conteo = new HashMap<>();

        for (Ciudadano c : registro.keySet()) {
            String provincia = c.getProvincia();

            if (conteo.containsKey(provincia)) {

                conteo.put(provincia, conteo.get(provincia) + 1);
            } else {

                conteo.put(provincia, 1);
            }
        }
        System.out.println("Personas vacunadas por provincia:");
        for (Map.Entry<String, Integer> valor : conteo.entrySet()){
            System.out.println(valor.getKey()+" tiene: "+ valor.getValue()+ " vacunados");
        }
    }
    //Saber qué ciudadanos cumplen con tener una determinada cantidad de vacunas pasada por parametro.
    public void vacunados(int n){
        HashSet<Ciudadano> aptos= new HashSet<>();
        for (Ciudadano c : registro.keySet()) {
            if (registro.get(c).size() >= n) {
                aptos.add(c);
            }
        }
        for(Ciudadano c : aptos){
            System.out.println(c.getApellido()+" ,");

        }
    }
    //Conocer, dado una vacuna determinada, qué ciudadanos ya se la dieron
    public void ciudadanosQueRecibieron(Vacuna v) {
        for (Ciudadano c : registro.keySet()) {
            //vacunas
            HashSet<Vacuna> vacunas = registro.get(c);

            if (vacunas != null) { // el ciudadano tiene vacunas registradas
                for (Vacuna v1 : vacunas) {
                    if (v1.getNombreComercial().equalsIgnoreCase(v.getNombreComercial())) {
                        System.out.println(c.getNombre() + " "  + c.getDni() + " ,");
                        break;
                    }
                }
            }
        }
    }


}
