package segundoCuatri.Poblacion;

import java.util.HashSet;

public abstract class Lugar {
    //Todos los tipos de lugares tienen un nombre, código y una lista de coordenadas (latitud y longitud)
    // que unidas representan el contorno del lugar
    private String nombre;
    private int codigo;
    private HashSet<Coordenadas> limite;

    public Lugar(String nombre, int codigo, HashSet<Coordenadas> limite) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.limite = limite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public HashSet<Coordenadas> getLimite() {
        return limite;
    }

    public void setLimite(HashSet<Coordenadas> limite) {
        this.limite = limite;
    }
    public abstract int censoPoblacion();
}
