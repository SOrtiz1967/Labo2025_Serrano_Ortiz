package eventos;

import grupos.DisponibilidadHoraria;
import grupos.EquipoCurling;

import java.time.LocalDate;

public class PartidoCurling {
    private EquipoCurling local;
    private EquipoCurling visitante;
    private LocalDate fechaPartido;
    private DisponibilidadHoraria turno;


    public PartidoCurling() {
        this.local= new EquipoCurling();
        this.visitante= new EquipoCurling();
        this.fechaPartido= LocalDate.of(2006,06,06);
        this.turno=DisponibilidadHoraria.TARDE;
    }

    public PartidoCurling(EquipoCurling local, EquipoCurling visitante, DisponibilidadHoraria turno, LocalDate fechaPartido) {
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

    public DisponibilidadHoraria getTurno() {
        return turno;
    }

    public void setTurno(DisponibilidadHoraria turno) {
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
