package sistemas;

import eventos.PartidoCurling;
import grupos.EquipoCurling;
import personas.JugadorCurling;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

public class SistemaCurling {

    private ArrayList <EquipoCurling> equipos;
    private ArrayList <EquipoCurling> equiposMañana;
    private ArrayList <EquipoCurling> equiposTarde;
    private ArrayList <EquipoCurling> equiposNoche;
    private ArrayList <PartidoCurling> fixture;

    public SistemaCurling() {
        this.equipos = new ArrayList<EquipoCurling> ();
        EquipoCurling eq1 = new EquipoCurling();
        this.equipos.add(eq1);
        this.fixture= new ArrayList<PartidoCurling>();

    }

    public SistemaCurling(ArrayList<EquipoCurling> equipos, ArrayList<PartidoCurling> fixture) {
        this.equipos = equipos;
        this.fixture = fixture;
    }

    public ArrayList<EquipoCurling> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<EquipoCurling> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<PartidoCurling> getFixture() {
        return fixture;
    }

    public void setFixture(ArrayList<PartidoCurling> fixture) {
        this.fixture = fixture;
    }
    public void llenarmatriz(){
        for(EquipoCurling equipo:equipos){
                equipo.noRepeatNumber;
                equipo.validacionDisponible;
                switch(equipo.disponibilidadHoraria){
                    case "tarde":
                        this.equiposTarde.add(this);
                        break;
                    case "noche":
                        this.equiposNoche.add(this);
                        break;
                    case "mañana":
                        this.equiposMañana.add(this);
                        break;
                }
            }
        }
    }
    public void enfrentarMatriz(EquipoCurling[] matriz){
        LocalDate fecha = LocalDate.now();
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){}
                this.fixture.add(matriz[i],matriz[j+1],fecha.plusDays(j*7),matriz[i].disponibilidadHoraria);
        }
    }
    public void llenarFixture(){
        this.enfrentarMatriz(equiposTarde);
        this.enfrentarMatriz(equiposNoche);
        this.enfrentarMatriz(equiposMañana);
    }
    public static void main(String[] args) {

        SistemaCurling sis1= new SistemaCurling();
        EquipoCurling e7= new EquipoCurling("Voka", "Nuñez", new ArrayList<>(), "tarde");
        sis1.equipos.add(e7);
        sis1.llenarFixture();
        for(int i=1;i<sis1.equipos.size();i++) {
            for (int h = 0; h < sis1.fixture.size(); h++) {
                System.out.println("Fecha" + i + ": " + "Local: " + sis1.fixture.get(h).getLocal().getNombre() + " Visitante: " + sis1.fixture.get(h).getVisitante().getNombre() + " Fecha: " + sis1.fixture.get(h).getFechaPartido() + " Disponibilidad Horario: " + sis1.fixture.get(h).getTurno());
            }
        }
        }



    }
