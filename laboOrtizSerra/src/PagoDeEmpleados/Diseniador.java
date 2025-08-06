package PagoDeEmpleados;

import java.util.HashMap;
import java.util.Map;

public class Diseniador {
    private Tipo tipo;
    private HashMap<Proyecto, Integer> proyectosAsignados= new HashMap<Proyecto, Integer>();
    private static HashMap<Tipo,Integer>comisiones = new HashMap<Tipo,Integer>();
    static {
        comisiones.put(Tipo.UI,7);
        comisiones.put(Tipo.UX, 8);
        comisiones.put(Tipo.IT, 12);
    }
    public void sumarComision(){
        for(Map.Entry<Tipo,Integer> t:Diseniador.comisiones.entrySet()) {
            if (t.getKey().equals(this.tipo)) {
                for (Map.Entry<Proyecto, Integer> p : this.proyectosAsignados.entrySet()) {
                    p.setValue(p.getValue() + (p.getValue() * t.getValue()) / 100);
                }
            }
        }
    }

    public Diseniador(Tipo tipo, HashMap<Proyecto, Integer> proyectosAsignados) {
        this.tipo = tipo;
        this.proyectosAsignados = proyectosAsignados;
    }

    public Diseniador() {
        this.tipo = Tipo.IT;
        this.proyectosAsignados = new HashMap<Proyecto, Integer>();
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

    public static void setComisiones(HashMap<Tipo, Integer> comisiones) {
        Diseniador.comisiones = comisiones;
    }

    public int miSueldo(){
        int sueldo=0;
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            sueldo+=p.getValue();
        }
        return sueldo;
    }
    public int cantidadDeProyectos(){
        return this.proyectosAsignados.size();
    }
    public int gananciaSinComision(Proyecto p){
        for(Map.Entry<Proyecto,Integer> pr:proyectosAsignados.entrySet()){
            if(pr.getKey().equals(p)){
                return pr.getKey().getPrecio();
            }
        }
        return 0;
    }
    public void sueldoDiscriminado(){
        for(Map.Entry<Proyecto,Integer> p:proyectosAsignados.entrySet()){
            int comision=p.getValue()-this.gananciaSinComision(p.getKey());
            System.out.println("Nombre del proyecto: "+ p.getKey().getNombre()+ "Cuanto ganó: "+ this.proyectosAsignados.get(p)+ "Comisión: "+ comision);
        }
    }
}
