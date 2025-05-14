package sistemas;

import eventos.PartidoCurling;
import grupos.EquipoCurling;
import personas.JugadorCurling;

import java.time.LocalDate;
import java.util.ArrayList;
public class SistemaCurling {

    private ArrayList<EquipoCurling> equipos;
    public ArrayList <EquipoCurling> equiposMañana;
    public ArrayList <EquipoCurling> equiposTarde;
    public ArrayList <EquipoCurling> equiposNoche;
    private ArrayList <PartidoCurling> fixture;

    public SistemaCurling() {
        this.equipos = new ArrayList<EquipoCurling> ();
        EquipoCurling eq1 = new EquipoCurling();
        this.equipos.add(eq1);
        this.equiposMañana = new ArrayList<>();
        this.equiposTarde = new ArrayList<>();
        this.equiposNoche = new ArrayList<>();
        this.fixture= new ArrayList<PartidoCurling>();

    }

    public SistemaCurling(ArrayList<EquipoCurling> equipos,ArrayList <EquipoCurling> equiposMañana, ArrayList <EquipoCurling> equiposTarde, ArrayList <EquipoCurling> equiposNoche, ArrayList<PartidoCurling> fixture) {
        this.equipos = equipos;
        this.equiposMañana = equiposMañana;
        this.equiposTarde = equiposTarde;
        this.equiposNoche = equiposNoche;
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
                equipo.noRepeatNumber();
                equipo.validacionDisponible();
                switch(equipo.getDisponibilidadHoraria()){
                    case "tarde":
                        this.equiposTarde.add(equipo);
                        break;
                    case "noche":
                        this.equiposNoche.add(equipo);
                        break;
                    case "mañana":
                        this.equiposMañana.add(equipo);
                        break;
                }
            }
        }

    public void enfrentarMatriz(ArrayList <EquipoCurling> matriz){
        LocalDate fecha = LocalDate.now();
        for(int i=0;i<matriz.size();i++) {
            for (int j = i+1; j < matriz.size(); j++) {
                EquipoCurling equipo1 = matriz.get(i);
                EquipoCurling equipo2 = matriz.get(j);
                String turno = equipo1.getDisponibilidadHoraria();

                PartidoCurling partido = new PartidoCurling(
                        equipo1,
                        equipo2,
                        turno,
                        fecha.plusDays((i + j) * 7)
                );

                this.fixture.add(partido);
            }
        }
    }
    public void llenarFixture(ArrayList <EquipoCurling> matriz){
        this.enfrentarMatriz(matriz);
    }
    public static void main(String[] args) {

        SistemaCurling sis1= new SistemaCurling();
        JugadorCurling j1= new JugadorCurling();
        EquipoCurling e7= new EquipoCurling("Voka", "Nuñez", new ArrayList<JugadorCurling>(), "tarde",j1);
        EquipoCurling e6= new EquipoCurling("Belgrano","Alberdi",new ArrayList<JugadorCurling>(),"tarde",j1);
        sis1.equipos.add(e6 );
        sis1.equipos.add(e7);
        sis1.llenarmatriz();
        sis1.llenarFixture(sis1.equiposNoche);
        sis1.llenarFixture(sis1.equiposTarde);
        sis1.llenarFixture(sis1.equiposMañana);

        for (int h = 0; h < sis1.fixture.size(); h++) {
            PartidoCurling partido = sis1.fixture.get(h);
            System.out.println("Partido " + (h + 1) + ": Local: " + partido.getLocal().getNombre()
                    + " | Visitante: " + partido.getVisitante().getNombre()
                    + " | Fecha: " + partido.getFechaPartido()
                    + " | Turno: " + partido.getTurno());
        }

    }



}


