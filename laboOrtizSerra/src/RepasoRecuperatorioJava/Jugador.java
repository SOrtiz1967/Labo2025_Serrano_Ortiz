package RepasoRecuperatorioJava;

public class Jugador {
    private String nombre;
    private int tag;
    private String clan;
    private int nivelRey;
    private Arena arena;

    public Jugador(String nombre, int tag, String clan, int nivelRey, Arena arena) {
        this.nombre = nombre;
        this.tag = tag;
        this.clan = clan;
        this.nivelRey = nivelRey;
        this.arena = arena;
    }

    public Jugador() {
        this.nombre = "";
        this.tag = 0;
        this.clan = "";
        this.nivelRey = 0;
        this.arena = Arena.LABO;
    }
}
