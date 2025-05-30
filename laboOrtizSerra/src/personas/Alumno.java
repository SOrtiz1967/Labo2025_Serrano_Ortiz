package personas;

import fecha.Fecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Alumno extends Persona {
    /*
    nombre, apellido, fechaNacimiento, listaDeNotas

    Métodos:

    Getters y setters de todos los atributos.
    agregarNota()
    menorNota()
    mayorNota()

     */

    private LocalDate fechaNacimiento;
    private ArrayList<Double> notas;
    private String division;
    //constructores
    public Alumno(String nombre, String apellido, LocalDate fechaNacimiento, ArrayList<Double> notas) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
    }
    public Alumno(String nombre,String apellido, String division){
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.division=division;
    }
    public Alumno(){
        super.setNombre("");
        super.setApellido("");
        this.fechaNacimiento= LocalDate.of(0,0, 0);
        this.notas= new ArrayList<Double>();
        notas.add(10.0);
        notas.add(10.0);
        notas.add(9.50);
    }
    //getters y setters


    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }
    public void agregarNota(){
        System.out.print("ingresa la nota: ");
        Scanner n = new Scanner(System.in);
        double notaAux= n.nextDouble();;
        notas.add(notaAux);
    }
    public double menorNota(){
        double notaBaja=notas.get(0);
        for (Double nota : notas){
            if(notaBaja>nota){
                notaBaja=nota;
            }
        }
        return notaBaja;
    }
    public Double notaAlta() {
        double notaAlta = notas.get(0);
        for (Double nota : notas) {
            if (notaAlta < nota) {
                notaAlta = nota;
            }
        }
        return notaAlta;
    }

    public double calcularProm(){
        double promedio=0;
        double suma=0;
        for (Double nota : notas){
            suma+=nota;
        }
        promedio= suma/notas.size();
        return promedio;
    }

    public static void main(String[] args) {
        Alumno a1= new Alumno();
        System.out.println("el alumno se llama: " + a1.getNombre() +" "+ a1.getApellido() +
                "y nació el "+ a1.fechaNacimiento.getDayOfMonth()+"/"+a1.fechaNacimiento.getMonth()+"/"+a1.fechaNacimiento.getYear());
        System.out.print("sus notas son: ");
        for (double nota: a1.getNotas()){
            System.out.print(nota+", ");
        }
        a1.agregarNota();
        System.out.println("la nota mas baja es: "+ a1.menorNota()+ " la nota mas alta es: "+ a1.notaAlta());
        for (double nota: a1.getNotas()){
            System.out.print(nota+", ");
        }
    }


}
