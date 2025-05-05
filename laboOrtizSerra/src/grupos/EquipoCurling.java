package grupos;

import personas.JugadorCurling;

import java.time.temporal.JulianFields;
import java.util.ArrayList;

public class EquipoCurling {
    private String nombre;
    private String barrio;
    private ArrayList<JugadorCurling> jugadores;
    private String disponibilidadHoraria;
    private JugadorCurling capitan;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
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

    public JugadorCurling getCapitan() {
        return capitan;
    }

    public void setCapitan(JugadorCurling capitan) {
        this.capitan = capitan;
    }

    public EquipoCurling(String nombre, String barrio, ArrayList<JugadorCurling> jugadores, String disponibilidadHoraria, JugadorCurling capitan) {
        this.nombre = nombre;
        this.barrio = barrio;
        this.jugadores = jugadores;
        this.disponibilidadHoraria = disponibilidadHoraria;
        this.capitan = capitan;
    }
    public EquipoCurling() {
        this.nombre = "San Lorenzo";
        this.barrio = "Indeterminado";
        this.jugadores = new ArrayList<JugadorCurling>();
        JugadorCurling j1= new JugadorCurling();
        jugadores.add(j1);
        this.disponibilidadHoraria = "tarde";
        this.capitan = j1;
    }

    public void noRepeatNumber(){
        ArrayList<Integer> numeros  = new ArrayList<Integer>();
        for (JugadorCurling jugador : this.jugadores){
            numeros.add(jugador.getNumeroCamiseta());
            for(int numero:numeros)
                if(jugador.getNumeroCamiseta()==numero){
                    jugador.setNumeroCamiseta((int) (Math.random()*100));
                }
        }
    }
    public void validacionDisponible(){
        this.setDisponibilidadHoraria(this.getDisponibilidadHoraria().toLowerCase());
        if(this.getDisponibilidadHoraria()!="tarde"){
            if(this.getDisponibilidadHoraria()!="mañana"){
                if(this.getDisponibilidadHoraria()!="noche"){
                    this.setDisponibilidadHoraria("Indefinido");
                }
            }
        }
    }

}
