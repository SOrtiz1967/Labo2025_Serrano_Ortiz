package Mascotas;

import personas.Persona;

public class Pez extends Mascota{
    private int vidas=10;

    public Pez(String nombre, Persona duenio) {
        super(nombre, duenio);
    }
    public Pez() {
        super();
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    @Override
    public String Saludo(){
        return "";
    }
    public void serSaludado(String nombreUsuario){
        if(this.getDuenio().getNombre().equals(nombreUsuario)){
            this.vidas--;
        }
        else {
            this.vidas=0;
        }
    }
    public String queSoy(){
        return "Pez";
    }
    public boolean estoyMuerto(){
        if(this.vidas==0){
            return true;
        }
        else {
            return false;
        }
    }
    public void alimentar(){
        this.vidas++;
    }
}
