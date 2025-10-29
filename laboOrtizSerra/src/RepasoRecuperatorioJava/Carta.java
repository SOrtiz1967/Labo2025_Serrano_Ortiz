package RepasoRecuperatorioJava;

import java.util.HashSet;

public abstract class Carta {
    private String nombre;
    private double danio;
    private double vida;
    private Arena arenaDesbloqueo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public Arena getArenaDesbloqueo() {
        return arenaDesbloqueo;
    }

    public void setArenaDesbloqueo(Arena arenaDesbloqueo) {
        this.arenaDesbloqueo = arenaDesbloqueo;
    }

    public Carta(String nombre, double danio, double vida, Arena arenaDesbloqueo) {
        this.nombre = nombre;
        this.danio = danio;
        this.vida = vida;
        this.arenaDesbloqueo = arenaDesbloqueo;
    }

    public Carta() {
        this.nombre = "";
        this.danio = 0;
        this.vida = 0;
        this.arenaDesbloqueo = Arena.LABO;
    }

    public abstract void frase();
    public abstract HashSet<Double> valoresAtributos();
}
