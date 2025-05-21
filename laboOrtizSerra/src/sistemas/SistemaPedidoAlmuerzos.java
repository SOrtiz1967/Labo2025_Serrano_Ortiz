package sistemas;

import Pedidos.Pedido;
import objetos.Plato;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaPedidoAlmuerzos {
    private ArrayList<Plato>platos;
    private ArrayList<Pedido>pedidos;

    public SistemaPedidoAlmuerzos(ArrayList<Plato> platos, ArrayList<Pedido> pedidos) {
        this.platos = platos;
        this.pedidos = pedidos;
    }

    public SistemaPedidoAlmuerzos() {
        this.platos=new ArrayList<Plato>();
        this.pedidos=new ArrayList<Pedido>();
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
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
    public ArrayList<Plato> platosACocinarEnElDia(){
        ArrayList<Plato> platosacocinar= new ArrayList<>();
        for(Pedido pedido: this.pedidos){
            if(pedido.getF_c().equals(LocalDate.now()) && pedido.isEntregado()==true){
                Plato platoacocinar=pedido.getPlato();
                platosacocinar.add(platoacocinar);
            }
        }
        return platosacocinar;
    }
    public int cantidaddevecespedidas(Plato plato){
        int cantidad_de_veces_pedidas=0;
        for(Pedido pedido: this.pedidos){
            if(pedido.getPlato().equals(plato)){
                cantidad_de_veces_pedidas++;
            }
        }
        return cantidad_de_veces_pedidas;
    }
    public ArrayList<Plato> top3(){
        ArrayList<Plato> top3=new ArrayList<>();
        for(Plato plato: this.platos){
            this.cantidaddevecespedidas(plato);
        }
        return top3;
    }
}

