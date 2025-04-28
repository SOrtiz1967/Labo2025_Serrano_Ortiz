package sistemas;

import eventos.PartidoCurling;
import grupos.EquipoCurling;
import personas.JugadorCurling;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

public class SistemaCurling {

    private ArrayList <EquipoCurling> equipos;

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
    public void llenarFixture(){
        for(int i=0;i<this.equipos.size();i++){
            for (int j=0;j==this.equipos.size()/2;j++){
                for(int h=0;h<this.equipos.size();h+=2){
                    fixture.add(new PartidoCurling(this.equipos.get(h),this.equipos.get(h+1),this.equipos.get(h).compararDisponibilidad(this.equipos.get(h+1)), LocalDate.now().plusDays(j*7)));
                }
            }
        }
    }
    /*
    alternativa: solo con dos for, el elemento 0 va contra todos menos contra el mismo,
    el elemento 1 va a partir de el 2 por que ya jugo con el 0 y el 1 es el mismo, se puede poner como condicion del for i?
     */
    public static void main(String[] args) {

        SistemaCurling sis1= new SistemaCurling();
        EquipoCurling e7= new EquipoCurling("Voka", "Nuñez", new ArrayList<>(), "mañana");
        sis1.equipos.add(e7);
        sis1.llenarFixture();
        System.out.println();
        for (PartidoCurling partido : sis1.getFixture()){
            //
            System.out.println("local: "+ partido.getLocal()+ " visitante: "+ partido.getVisitante()+ "fecha: "+ partido.getFechaPartido());
        }



    }
}
