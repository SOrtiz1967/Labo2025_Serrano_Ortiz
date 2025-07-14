package objetos;


import Tecnologia.CPU;
import personas.User;

import java.util.ArrayList;

public class Compra {
    private User cliente;
    private CPU cpu;
    private ArrayList<Componente> perifericos;
    private MetodoPago metodoPago;

    public Compra(User cliente, CPU cpu, ArrayList<Componente> perifericos, MetodoPago metodoPago) {
        this.cliente = cliente;
        this.cpu = cpu;
        this.perifericos = perifericos;
        this.metodoPago = metodoPago;
    }
    public void validar(){
        int devices=0;
        int pc=0;
        for(Componente c: perifericos){
            if(c instanceof Entrada || c instanceof Salida) {
                devices++;
            }
            if(c instanceof CPU){
                pc++;
            }
        }
        if (devices > 1 && pc == 1) {
            System.out.println("¡Tu pedido fue validado correctamente!");
        } else {
            System.out.println("Algo anda mal, tu pedido no cumple con los requisitos :(");
        }


    }
    public void actualizarStock(){
        for(Componente c: perifericos){
            c.restarStock(1);
        }
    }
    public double finalPrice(){
        double subtotal=0;
        double total=0;
        for(Componente c: perifericos){
            subtotal+= c.getPrecio();
        }
        total= metodoPago.calcularMonto(subtotal);
        return total;
    }
    public int contarDispositivos() {
        int count = 0;
        for(Componente p : perifericos) {
            if(p instanceof Entrada || p instanceof Salida) {
                count++;
            }
        }
        return count;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public ArrayList<Componente> getPerifericos() {
        return perifericos;
    }

    public void setPerifericos(ArrayList<Componente> perifericos) {
        this.perifericos = perifericos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
