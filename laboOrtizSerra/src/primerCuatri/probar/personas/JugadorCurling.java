package primerCuatri.probar.personas;

import java.time.LocalDate;

public class JugadorCurling extends Persona {
    private LocalDate FechaNacimiento;
    private int numeroCamiseta;

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

    public JugadorCurling(String nombre, LocalDate fechaNacimiento, int numeroCamiseta) {
        super.setNombre(nombre);
        FechaNacimiento = fechaNacimiento;
        this.numeroCamiseta = numeroCamiseta;
    }

    public JugadorCurling() {
        this.numeroCamiseta=8;
        super.setNombre("Jose Pascual Tamborini");
        this.FechaNacimiento=LocalDate.of(2007, 7, 9);
    }
}
