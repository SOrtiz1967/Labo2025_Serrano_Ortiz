package segundoCuatri.ControlCalorias;

public class Ingrediente {
    private String nombre;
    private int calorias;

    public Ingrediente(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias=calorias;
    }

    public Ingrediente() {
        this.nombre="";
        this.calorias=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombre='" + nombre + '\'' +
                ", calorias=" + calorias +
                '}';
    }
}
