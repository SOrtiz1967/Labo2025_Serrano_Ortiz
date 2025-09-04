package primerCuatri.probar.Mascotas;

import primerCuatri.probar.personas.Persona;

public abstract class Mascota {
    private String nombre;
    private Persona duenio;
    private int alegria=0;

    public Mascota(String nombre, Persona duenio) {
        this.nombre = nombre;
        this.duenio = duenio;
    }

    public Mascota() {
        this.nombre = "";
        this.duenio = new Persona();}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    public abstract String Saludo();
    public abstract void serSaludado(String nombreUsuario);
    public abstract String queSoy();
    public abstract boolean estoyMuerto();
    public abstract void alimentar();
}
