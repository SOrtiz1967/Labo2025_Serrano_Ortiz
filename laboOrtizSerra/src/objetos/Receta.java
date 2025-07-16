package objetos;

import java.util.ArrayList;

public abstract class Receta {
    private String nombre;
    private Dificultad dificultad;
    private ArrayList<String> listadepasos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<String> getListadepasos() {
        return listadepasos;
    }

    public void setListadepasos(ArrayList<String> listadepasos) {
        this.listadepasos = listadepasos;
    }

    public Receta(String nombre, Dificultad dificultad, ArrayList<String> listadepasos) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.listadepasos = listadepasos;
    }

    public Receta() {
        this.nombre="XX";
        this.dificultad=Dificultad.FACIL;
        this.listadepasos=new ArrayList<String>();
    }
    abstract void MostrarReceta();
    //abstract void Tipo();
    

}
