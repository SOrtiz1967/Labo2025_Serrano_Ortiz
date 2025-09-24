package EJ1;

import segundoCuatri.arcoyflecha.Color;

import java.time.LocalDate;

public class PlatoRepaso extends primerCuatri.probar.objetos.Plato {
    private String apellido;
    private LocalDate fechaN;
    private String localidad;
    private Color colorPlato;

    public PlatoRepaso(String nombre, double precio, String apellido, LocalDate fechaN, String localidad, Color colorPlato) {
        super(nombre, precio);
        this.apellido = apellido;
        this.fechaN = fechaN;
        this.localidad = localidad;
        this.colorPlato = colorPlato;
    }

    public PlatoRepaso() {
        super();
        this.apellido = "";
        this.fechaN = LocalDate.of(0,0,0);
        this.localidad = "";
        this.colorPlato = Color.ROJO;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaN() {
        return fechaN;
    }

    public void setFechaN(LocalDate fechaN) {
        this.fechaN = fechaN;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Color getColorPlato() {
        return colorPlato;
    }

    public void setColorPlato(Color colorPlato) {
        this.colorPlato = colorPlato;
    }
}
