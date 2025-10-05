package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.arcoyflecha.Color;

public class Experto extends Participante implements CocinaryservirEntrada, CocinaryservirPrincipal {
    private static int tiempo=80;
    private int tiempoRestantePersonal;

    public Experto(String nombre, int edad, String apellido, String direccion, Color equipo) {
        super(nombre, edad, apellido, direccion,equipo);
        this.tiempoRestantePersonal=tiempo;
    }

    public Experto() {
        super();
        this.tiempoRestantePersonal=tiempo;
    }

    public static int getTiempo() {
        return tiempo;
    }

    public static void setTiempo(int tiempo) {
        Experto.tiempo = tiempo;
    }

    public int getTiempoRestantePersonal() {
        return tiempoRestantePersonal;
    }

    public void setTiempoRestantePersonal(int tiempoRestantePersonal) {
        this.tiempoRestantePersonal = tiempoRestantePersonal;
    }

    @Override
    public void mensaje(){
        System.out.println( "Perdi 5 minutos preparando la mesa por lo que mi tiempo restante es: "+ (this.tiempoRestantePersonal-5));
    }
    @Override
    public boolean cocinarPrincipal(PlatoRepaso principal) {
        try {
            if (principal.getTiempoCoccion() > this.tiempoRestantePersonal) {
                throw new FueraDeTiempoException("El experto no cuenta con el tiempo suficiente para cocinar el plato principal");
            }
            return true;
        } catch (FueraDeTiempoException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    @Override
    public void servirPrincipal(PlatoRepaso principal){
        if(cocinarPrincipal(principal)){
            System.out.println("el experto sirve el plato principal");
        }
    }
    @Override
        public boolean cocinarEntrada(PlatoRepaso entrada){
            try {
                if (entrada.getTiempoCoccion() > this.tiempoRestantePersonal) {
                    throw new FueraDeTiempoException("El experto no cuenta con el tiempo suficiente para cocinar el plato entrada");
                }
                return true;
            } catch (FueraDeTiempoException e) {
                e.getMessage();
                return false;
            }
        }
        @Override
        public void servirEntrada(PlatoRepaso entrada){
        if(cocinarEntrada(entrada)){
            System.out.println("el experto sirve la entrada");
        }
    }

}
