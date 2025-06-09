package personas;

public class Profesor extends Persona {
    private static int porcentaje_descuento;


    public Profesor(String nombre, int edad, String apellido, String direccion, int porcentaje_descuento) {
        super(nombre, edad, apellido, direccion);

    }

    public Profesor() {
        super.setNombre("");
        super.setApellido("");

    }

    public static int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }


}
