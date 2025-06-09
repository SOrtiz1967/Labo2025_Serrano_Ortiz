package objetos;

public class CargadorPortatil extends ProductoElectronico {
    private int cantidadCargas;

    public CargadorPortatil(String nombre, int precio, int stock, Seccion seccion, int cantidadCargas) {
        super(nombre, precio, stock, seccion);
        this.cantidadCargas = cantidadCargas;
    }
    public CargadorPortatil(int cantidadCargas) {
        this.cantidadCargas = cantidadCargas;
    }

    public int getCantidadCargas() {
        return cantidadCargas;
    }

    public void setCantidadCargas(int cantidadCargas) {
        this.cantidadCargas = cantidadCargas;
    }

    public CargadorPortatil() {
        this.cantidadCargas=10000;
    }
}
