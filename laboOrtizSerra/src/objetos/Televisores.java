package objetos;

import Tecnologia.ProductoElectronico;
import Tecnologia.Tecnología;

public class Televisores extends ProductoElectronico {
    private int resolucion;
    private Tecnología tecnología;

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public Tecnología getTecnología() {
        return tecnología;
    }

    public void setTecnología(Tecnología tecnología) {
        this.tecnología = tecnología;
    }

    public Televisores(String nombre, int precio, int stock, Seccion seccion, int resolucion, Tecnología tecnología) {
        super(nombre, precio, stock, seccion);
        this.resolucion = resolucion;
        this.tecnología = tecnología;
    }

    public Televisores(int resolucion, Tecnología tecnología) {
        this.resolucion = resolucion;
        this.tecnología = tecnología;
    }

    public Televisores(String nombre, int precio, int stock, Seccion seccion) {
        super(nombre, precio, stock, seccion);
        this.resolucion=300;
        this.tecnología=Tecnología.CUATROK;
    }
}
