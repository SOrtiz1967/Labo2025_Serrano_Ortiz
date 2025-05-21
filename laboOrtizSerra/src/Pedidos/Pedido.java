package Pedidos;

import objetos.Plato;
import personas.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {
    private LocalDate f_c;
    private Plato plato;
    private Persona solicitante;
    private LocalTime h_e;
    private boolean entregado;

    public Pedido(LocalDate f_c, Plato plato, Persona solicitante, LocalTime h_e, boolean entregado) {
        this.f_c = f_c;
        this.plato = plato;
        this.solicitante = solicitante;
        this.h_e = h_e;
        this.entregado = entregado;
    }

    public Pedido() {
        this.f_c = LocalDate.of(0,0,0);
        this.plato=new Plato("",0);
        this.solicitante=new Persona();
        this.h_e= LocalTime.of(0,0);
        this.entregado=true;

    }

    public LocalDate getF_c() {
        return f_c;
    }

    public void setF_c(LocalDate f_c) {
        this.f_c = f_c;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public LocalTime getH_e() {
        return h_e;
    }

    public void setH_e(LocalTime h_e) {
        this.h_e = h_e;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}
