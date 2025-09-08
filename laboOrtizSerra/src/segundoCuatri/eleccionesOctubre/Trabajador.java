package segundoCuatri.eleccionesOctubre;

import primerCuatri.probar.personas.Persona;
import java.time.LocalDate;
public class Trabajador extends Persona implements AccionesCampaña{
    // En el caso de los trabajadores habrá que conocer no sólo el nombre, apellido, dni, fecha de nacimiento
    // sino también el número de cuil, el sueldo y la dirección de residencia.
    private int cuil;
    private int sueldo;//ashuutateeeeeee
    private String direccion;
    private int entrada;
    private int salida;

    public Trabajador(int cuil, int sueldo, String direccion) {
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion;
    }

    public Trabajador(String nombre, int edad, String apellido, String direccion, int cuil, int sueldo, String direccion1) {
        super(nombre, edad, apellido, direccion);
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion1;
    }

    public Trabajador(String nombre, int edad, int cuil, int sueldo, String direccion) {
        super(nombre, edad);
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion;
    }

    public Trabajador(int cuil, int sueldo, String direccion, int entrada, int salida) {
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Trabajador(String nombre, int edad, String apellido, String direccion, int cuil, int sueldo, String direccion1, int entrada, int salida) {
        super(nombre, edad, apellido, direccion);
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion1;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Trabajador(String nombre, int edad, int cuil, int sueldo, String direccion, int entrada, int salida) {
        super(nombre, edad);
        this.cuil = cuil;
        this.sueldo = sueldo;
        this.direccion = direccion;
        this.entrada = entrada;
        this.salida = salida;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String hacerCampaña() {
        if (FechaHoraLaboral.obtenerFechaHoraYLaboral(entrada, salida)){
            return "Yo, "+ getNombre()+" te invito a que";

        }
        return "";
    }
}
