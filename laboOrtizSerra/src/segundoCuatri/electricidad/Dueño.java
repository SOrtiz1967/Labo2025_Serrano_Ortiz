package segundoCuatri.electricidad;

import primerCuatri.probar.personas.Persona;

public class Dueño extends Persona {
    public Dueño() {
    }

    public Dueño(String nombre, int edad, String apellido, String direccion) {
        super(nombre, edad, apellido, direccion);
    }

    public Dueño(String nombre, int edad) {
        super(nombre, edad);
    }
}
