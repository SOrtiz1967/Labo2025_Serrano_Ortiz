package sistemas;

import objetos.Materia;
import primerCuatri.probar.personas.Alumno;

import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;

public class SistemaCole {
    private ArrayList <Alumno> alumnos_sistema;
    private ArrayList <Materia> materias_sistema;

    public ArrayList<Alumno> getAlumnos_sistema() {
        return alumnos_sistema;
    }

    public void setAlumnos_sistema(ArrayList<Alumno> alumnos_sistema) {
        this.alumnos_sistema = alumnos_sistema;
    }

    public ArrayList<Materia> getMaterias_sistema() {
        return materias_sistema;
    }

    public void setMaterias_sistema(ArrayList<Materia> materias_sistema) {
        this.materias_sistema = materias_sistema;
    }

    public SistemaCole(ArrayList<Alumno> alumnos_sistema, ArrayList<Materia> materias_sistema) {
        this.alumnos_sistema = alumnos_sistema;
        this.materias_sistema = materias_sistema;
    }

    public SistemaCole() {
        this.alumnos_sistema=new ArrayList<Alumno>();
        Alumno a1= new Alumno();
        alumnos_sistema.add(a1);
        this.materias_sistema= new ArrayList<Materia>();
        Materia m1=new Materia();
        materias_sistema.add(m1);
    }
    public void agregarMateria(Materia materia){
        materias_sistema.add(materia);
    }
    public void promedio(){
        for (Alumno alumno : alumnos_sistema){
            System.out.println("Nombre del alumno: " + alumno.getNombre() + " y el promedio del alumno es: " + alumno.calcularProm());
        }
    }
    public double promedio_edad(){
        double prom=0;
        Period periodo;
        int edad;
        LocalDate fechaActual = LocalDate.now();

        for (Alumno alumno : alumnos_sistema){
            periodo= Period.between(alumno.getFechaNacimiento(),fechaActual);
            edad=periodo.getYears();
            prom+=edad;
        }
        prom=prom/alumnos_sistema.size();
        return prom;
    }


    public static void main(String[] args) {
        SistemaCole sc1 = new SistemaCole();
        System.out.println("El promedio de edad del sistema de alumnos es: " + sc1.promedio_edad());
        sc1.promedio();
    }
}
