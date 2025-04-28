package personas;

import java.time.LocalDate;

public class JugadorCurling {
    private String nombre;
    private LocalDate FechaNacimiento;
    private int numeroCamiseta;
    private boolean capitan;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public boolean getCapitan() {
        return capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }

    public JugadorCurling(String nombre, LocalDate fechaNacimiento, int numeroCamiseta, boolean capitan) {
        this.nombre = nombre;
        FechaNacimiento = fechaNacimiento;
        this.numeroCamiseta = numeroCamiseta;
        this.capitan = capitan;
    }

    public JugadorCurling() {
        this.capitan=false;
        this.numeroCamiseta=8;
        this.nombre="Jose Pascual Tamborini";
        this.FechaNacimiento=LocalDate.of(2007, 7, 9);
    }
}

