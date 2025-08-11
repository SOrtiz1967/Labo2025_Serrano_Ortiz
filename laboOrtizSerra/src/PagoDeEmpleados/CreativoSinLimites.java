package PagoDeEmpleados;

import java.util.HashMap;
import java.util.HashSet;

public class CreativoSinLimites {
    private HashSet<Proyecto> proyectos = new HashSet<Proyecto>();
    private HashSet<Diseniador> diseniadores= new HashSet<Diseniador>();
    private static HashMap<Tipo,Integer>comisiones = CreativoSinLimites.comisionesCreacion();

    public static HashMap<Tipo,Integer> comisionesCreacion() {
        HashMap<Tipo,Integer>comisiones = new HashMap<Tipo,Integer>();
        comisiones.put(Tipo.UI,7);
        comisiones.put(Tipo.UX, 8);
        comisiones.put(Tipo.IT, 12);
        return comisiones;
    }

    public CreativoSinLimites(HashSet<Proyecto> proyectos, HashSet<Diseniador> diseniadores) {
        this.proyectos = proyectos;
        this.diseniadores = diseniadores;
    }

    public CreativoSinLimites() {
        this.proyectos = new HashSet<Proyecto>();
        this.diseniadores = new HashSet<Diseniador>();
    }

    public HashSet<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(HashSet<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public HashSet<Diseniador> getDiseniadores() {
        return diseniadores;
    }

    public void setDiseniadores(HashSet<Diseniador> diseniadores) {
        this.diseniadores = diseniadores;
    }

    public static HashMap<Tipo, Integer> getComisiones() {
        return comisiones;
    }

    public static void setComisiones(HashMap<Tipo, Integer> comisiones) {
        CreativoSinLimites.comisiones = comisiones;
    }

    public static void main(String[] args) {
        Proyecto p1= new Proyecto("Web e-commerce",1000);
        Proyecto p2= new Proyecto("Web informativa",800);
        HashMap<Proyecto, Integer> proyectosAsignados1= new HashMap<Proyecto, Integer>();
        HashMap<Proyecto, Integer> proyectosAsignados2= new HashMap<Proyecto, Integer>();
        proyectosAsignados1.put(p1,p1.getPrecio());
        proyectosAsignados2.put(p2,p2.getPrecio());
        Diseniador d1=new Diseniador(Tipo.UI,proyectosAsignados1);
        Diseniador d2=new Diseniador(Tipo.IT,proyectosAsignados2);
        d1.sumarComision();
        d2.sumarComision();
        HashSet<Proyecto> proyectos = new HashSet<Proyecto>();
        proyectos.add(p1);
        proyectos.add(p2);
        HashSet<Diseniador> diseniadores= new HashSet<Diseniador>();
        diseniadores.add(d1);
        diseniadores.add(d2);
        CreativoSinLimites c1= new CreativoSinLimites(proyectos,diseniadores);
        for (Diseniador d: diseniadores){
            System.out.println(d.getClass().getSimpleName());
            System.out.println("sueldo: "+ d.miSueldo());
            System.out.println("proyectos realizados hasta el momento: "+d.cantidadDeProyectos());
            System.out.println("ganancia sin comision con p1: "+d.gananciaSinComision(p1));
            d.sueldoDiscriminado();
        }
    }
}
