package PagoDeEmpleados;

import java.util.HashMap;
import java.util.Map;

public class Diseniador {
    private Tipo tipo;
    private HashMap<Proyecto, Integer> proyectosAsignados= new HashMap<Proyecto, Integer>();
    private HashMap<Tipo,Integer>comisiones = new HashMap<Tipo,Integer>();


    public Diseniador(Tipo tipo, HashMap<Proyecto, Integer> proyectosAsignados, HashMap<Tipo, Integer> comisiones) {
        this.tipo = tipo;
        this.proyectosAsignados = proyectosAsignados;
        this.comisiones = comisiones;
    }

    public Diseniador() {
        this.tipo = Tipo.IT;
        this.proyectosAsignados = new HashMap<Proyecto, Integer>();
        this.comisiones = new HashMap<Tipo,Integer>();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public HashMap<Proyecto, Integer> getProyectosAsignados() {
        return proyectosAsignados;
    }

    public void setProyectosAsignados(HashMap<Proyecto, Integer> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }

    public HashMap<Tipo, Integer> getComisiones() {
        return comisiones;
    }

    public void setComisiones(HashMap<Tipo, Integer> comisiones) {
        this.comisiones = comisiones;
    }

    public int miSueldo(){
        int sueldo=0;
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            sueldo+=proyectosAsignados.get(p);
        }
        return sueldo;
    }
    public int cantidadDeProyectos(){
        return this.proyectosAsignados.size();
    }
    public int gananciaSinComision(Proyecto p){
       int gananciasinc=this.proyectosAsignados.get(p);
       int comision=this.comisiones.get(this.tipo);
       comision=(gananciasinc*comision)/100;
       return gananciasinc-comision;
    }
    public void sueldoDiscriminado(){
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            int comision=this.proyectosAsignados.get(p)-this.gananciaSinComision(p.getKey());
            System.out.println("Nombre del proyecto: "+ p.getKey().getNombre()+ "Cuanto ganó: "+ this.proyectosAsignados.get(p)+ "Comisión: "+ comision);
        }
    }
}
