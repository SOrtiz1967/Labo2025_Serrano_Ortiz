package sistemaComponentes;

import objetos.MetodoPago;
import personas.User;

import java.util.ArrayList;

public class CompraProductosInformaticos {
    private User cliente;
    private CPU cpu;
    private ArrayList<Componente> perifericos;
    private MetodoPago metodoPago;

    public CompraProductosInformaticos(User cliente, CPU cpu, ArrayList<Componente> perifericos, MetodoPago metodoPago) {
        this.cliente = cliente;
        this.cpu = cpu;
        this.perifericos = perifericos;
        this.metodoPago = metodoPago;
    }
    public void validar() {
        int devices = 0;
        int pc = 0;
        for (Componente c : perifericos) {
            if (c instanceof Entrada || c instanceof Salida) {
                devices++;
            }
            if (c instanceof CPU) {
                pc++;
            }
        }
        try {
            if (devices > 1 && pc == 1) {
                System.out.println("¡Tu pedido fue validado correctamente!");
            }
            else {
                throw new CompraInvalidaException("Tu compra es inválida, debes comprar como mínimo un device y una PC");
            }
        }
        catch(CompraInvalidaException c){
            System.err.println(c);
        }


    }
    public void actualizarStock(){
        for(Componente c: perifericos){
            try{
                if(c.getStock()>0){
                    c.restarStock(1);
                }
                else {
                    throw new IllegalArgumentException("El stock ya es cero");
                }
            }
            catch (IllegalArgumentException I){
                System.err.println(I.getMessage());
            }
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