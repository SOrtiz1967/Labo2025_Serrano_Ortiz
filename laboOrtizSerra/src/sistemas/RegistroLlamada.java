package sistemas;

import primerCuatri.probar.personas.Empleado6;

import java.util.ArrayList;

public class RegistroLlamada {
    private ArrayList<Llamada> llamadas;
    private ArrayList<Empleado6> empleados;

    public RegistroLlamada(ArrayList<Llamada> llamadas, ArrayList<Empleado6> empleados) {
        this.llamadas = llamadas;
        this.empleados = empleados;
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(ArrayList<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public ArrayList<Empleado6> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado6> empleados) {
        this.empleados = empleados;
    }
}
