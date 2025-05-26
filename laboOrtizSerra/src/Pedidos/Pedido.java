package Pedidos;

import objetos.Plato;
import personas.Persona;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido {
    private LocalDate f_c;
    private ArrayList<Plato> platos;
    private Persona solicitante;
    private LocalTime h_e;
    private boolean entregado;

    public Pedido(LocalDate f_c, ArrayList<Plato> plato, Persona solicitante, LocalTime h_e, boolean entregado) {
        this.f_c = f_c;
        this.platos = plato;
        this.solicitante = solicitante;
        this.h_e = h_e;
        this.entregado = entregado;
    }

    public Pedido() {
        this.f_c = LocalDate.of(0,0,0);
        this.platos=new ArrayList<Plato>();
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

    public ArrayList<Plato> getPlato() {
        return platos;
    }

    public void setPlato(ArrayList<Plato> plato) {
        this.platos = plato;
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
    public void agregar_p (Plato pl){
        this.platos.add(pl);
    }
    public void eliminar_p(Plato pl){
        this.platos.remove(pl);
    }
    public void modificar_p(Plato pl,Plato platoARemover){
        this.agregar_p(pl);
        this.eliminar_p(platoARemover);
    }

}
