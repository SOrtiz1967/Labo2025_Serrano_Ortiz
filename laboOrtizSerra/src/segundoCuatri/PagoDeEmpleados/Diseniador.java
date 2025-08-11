package segundoCuatri.PagoDeEmpleados;

import personas.Persona;

import java.util.HashMap;
import java.util.Map;

public class Diseniador extends Persona {
    private Tipo tipo;
    private HashMap<Proyecto, Integer> proyectosAsignados= new HashMap<Proyecto, Integer>();

    public void sumarComision(){
        for(Map.Entry<Tipo,Integer> t:CreativoSinLimites.getComisiones().entrySet()) {
            if (t.getKey().equals(this.tipo)) {
                for (Map.Entry<Proyecto, Integer> p : this.proyectosAsignados.entrySet()) {
                    p.setValue(p.getValue() + (p.getValue() * t.getValue()) / 100);
                }
            }
        }
    }

    public Diseniador() {
        super();
        this.tipo=Tipo.UI;
        this.proyectosAsignados= new HashMap<Proyecto, Integer>();
    }

    public Diseniador(String nombre, int edad, String apellido, String direccion, Tipo tipo, HashMap<Proyecto, Integer> proyectosAsignados) {
        super(nombre, edad, apellido, direccion);
        this.tipo = tipo;
        this.proyectosAsignados = proyectosAsignados;
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
            System.out.println("Nombre del proyecto: "+ p.getKey().getNombre()+ "  Cuanto ganó: "+ this.proyectosAsignados.get(p.getKey())+ " Comisión: "+ comision);
        }
    }
}
