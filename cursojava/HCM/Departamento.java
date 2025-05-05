

import java.util.ArrayList;

public class Departmento {
    private String nombre;
    private ArrayList <Empleado> empleados;

    public Departmento(){
        this.nombre = "libano";
        this.empleados = new ArrayList<>();
    }

    public Departmento(String nombre, ArrayList<Employee> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Employee> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Employee> empleados) {
        this.empleados = empleados;
    }

    public void mostrarEmpleados(){
        for (Employee empleado : empleados){
            System.out.println(empleado.getNombre());
        }
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Departmento d1 = new Departmento();
        d1.empleados.add(e1);
        d1.mostrarEmpleados();
    }
}