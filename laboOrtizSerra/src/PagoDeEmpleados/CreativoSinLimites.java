package PagoDeEmpleados;

import java.util.HashMap;
import java.util.HashSet;

public class CreativoSinLimites {
    private HashSet<Proyecto> proyectos = new HashSet<Proyecto>();
    private HashSet<Diseniador> diseniadores= new HashSet<Diseniador>();

    public CreativoSinLimites(HashSet<Proyecto> proyectos, HashSet<Diseniador> diseniadores) {
        this.proyectos = proyectos;
        this.diseniadores = diseniadores;
    }

    public CreativoSinLimites() {
        this.proyectos = new HashSet<Proyecto>();
        this.diseniadores = new HashSet<Diseniador>();
    }
}
