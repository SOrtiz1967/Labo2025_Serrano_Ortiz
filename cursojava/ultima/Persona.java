package objetos;

import java.time.LocalDate;

public abstract class Persona {
    private int dni;
    private int edad;
    private String nombre;
    private LocalDate fechaNacimiento;


    public Persona(int dni, int edad, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Persona() {
        this.dni = 1991919;
        this.edad = 19;
        this.nombre = "juan";
        this.fechaNacimiento = LocalDate.now();
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
