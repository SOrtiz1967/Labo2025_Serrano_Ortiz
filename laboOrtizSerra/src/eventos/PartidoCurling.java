package eventos;

import grupos.EquipoCurling;
import personas.JugadorCurling;

import java.time.LocalDate;
import java.util.ArrayList;

public class PartidoCurling {
    private EquipoCurling local;
    private EquipoCurling visitante;
    private LocalDate fechaPartido;
    private String turno;


    public PartidoCurling() {
        this.local= new EquipoCurling();
        this.visitante= new EquipoCurling();
        this.fechaPartido= LocalDate.of(2006,06,06);
        this.turno="mañana";
    }

    public PartidoCurling(EquipoCurling local, EquipoCurling visitante, String turno, LocalDate fechaPartido) {
        this.local = local;
        this.visitante = visitante;
        this.fechaPartido = fechaPartido;
        this.turno = turno;

    }

    public EquipoCurling getLocal() {
        return local;
    }

    public void setLocal(EquipoCurling local) {
        this.local = local;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(LocalDate fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public EquipoCurling getVisitante() {
        return visitante;
    }

    public void setVisitante(EquipoCurling visitante) {
        this.visitante = visitante;
    }
}
