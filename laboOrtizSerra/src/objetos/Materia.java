package objetos;

import fecha.Fecha;
import personas.Alumno;

import java.time.LocalDate;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<String> listaDeContenidos;
    private ArrayList<Alumno> alumnosInscriptos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getListaDeContenidos() {
        return listaDeContenidos;
    }

    public void setListaDeContenidos(ArrayList<String> listaDeContenidos) {
        this.listaDeContenidos = listaDeContenidos;
    }

    public ArrayList<Alumno> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public void setAlumnosInscriptos(ArrayList<Alumno> alumnosInscriptos) {
        this.alumnosInscriptos = alumnosInscriptos;
    }

    public Materia(String nombre, ArrayList<String> listaDeContenidos, ArrayList<Alumno> alumnosInscriptos) {
        this.nombre = nombre;
        this.listaDeContenidos = listaDeContenidos;
        this.alumnosInscriptos = alumnosInscriptos;
    }
    public Materia(){
        this.nombre="Labo";
        this.alumnosInscriptos=new ArrayList<Alumno>();
        alumnosInscriptos.add(new Alumno());
        alumnosInscriptos.add(new Alumno("Benjamin", "Serrano", LocalDate.of(2008,3,7),new ArrayList<Double>()));
        this.listaDeContenidos= new ArrayList<String>();
        listaDeContenidos.add("clases");
        listaDeContenidos.add("metodos");
        listaDeContenidos.add("arrays");

    }

}
