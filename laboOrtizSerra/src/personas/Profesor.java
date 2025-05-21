package personas;

public class Profesor extends Persona {
    private int porcentaje_descuento;


    public Profesor(String nombre, int edad, String apellido, String direccion, int porcentaje_descuento) {
        super(nombre, edad, apellido, direccion);
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public Profesor() {
        super.setNombre("");
        super.setApellido("");
        this.porcentaje_descuento=0;
    }

    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

}
