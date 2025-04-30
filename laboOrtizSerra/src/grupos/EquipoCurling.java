package grupos;

import personas.JugadorCurling;

import java.time.temporal.JulianFields;
import java.util.ArrayList;

public class EquipoCurling {
    private String nombre;
    private String barrio;

    private ArrayList<JugadorCurling> jugadores;
    private String disponibilidadHoraria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public EquipoCurling(String nombre, String barrio, ArrayList<JugadorCurling> jugadores, String disponibilidadHoraria) {
        this.nombre = nombre;
        this.barrio = barrio;
        this.jugadores = jugadores;
        this.disponibilidadHoraria = disponibilidadHoraria;
    }

    public EquipoCurling() {
        this.nombre = "San Lorenzo";
        this.barrio = "Indeterminado";
        this.jugadores = new ArrayList<JugadorCurling>();
        JugadorCurling j1= new JugadorCurling();
        jugadores.add(j1);
        this.disponibilidadHoraria = "tarde";
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public ArrayList<JugadorCurling> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<JugadorCurling> jugadores) {
        this.jugadores = jugadores;
    }

    public String getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(String disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }

    public void noRepeatNumberCaptain(){
        ArrayList<Integer> numeros  = new ArrayList<Integer>();
        ArrayList<Boolean> capitanes  = new ArrayList<Boolean>();
        for (JugadorCurling jugador : this.jugadores){
            numeros.add(jugador.getNumeroCamiseta());
            capitanes.add(jugador.getCapitan());
            for(int numero:numeros)
                if(jugador.getNumeroCamiseta()==numero){
                    jugador.setNumeroCamiseta((int) (Math.random()*100));
                }
            for(Boolean capitan: capitanes){
                if(jugador.getCapitan()==capitan){
                    jugador.setCapitan(false);
                }
            }
        }
    }
    public void validacionDisponible(){
        this.setDisponibilidadHoraria(getDisponibilidadHoraria().toLowerCase());
        if(this.getDisponibilidadHoraria().toLowerCase() == "mañana"){
            this.setDisponibilidadHoraria(getDisponibilidadHoraria().toLowerCase());
        }
        else if (this.getDisponibilidadHoraria().toLowerCase()=="tarde" ){
            this.setDisponibilidadHoraria(getDisponibilidadHoraria().toLowerCase());
        }
        else if (this.getDisponibilidadHoraria().toLowerCase()=="noche"){
            this.setDisponibilidadHoraria(getDisponibilidadHoraria().toLowerCase());
        }
        else{
            this.setDisponibilidadHoraria("Indefinida");
        }
    }
    public String compararDisponibilidad(EquipoCurling e2){
        this.validacionDisponible();
        e2.validacionDisponible();
        if(this.getDisponibilidadHoraria() == e2.getDisponibilidadHoraria()){
            return this.getDisponibilidadHoraria();
        }
        else{
            return "no existe";
        }
    }
}
