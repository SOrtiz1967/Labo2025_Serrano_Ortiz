package Mascotas;

import personas.Persona;

public class PajaroNoCantor extends Mascota{

    public PajaroNoCantor(String nombre, Persona duenio) {
        super(nombre, duenio);

    }

    public PajaroNoCantor() {
        super();
    }

    @Override
    public String Saludo(){
        return "pio";}
    public void serSaludado(String nombreUsuario){
        if(this.getDuenio().getNombre().equals(nombreUsuario)){
            System.out.println(this.Saludo());
        }
    }
    public String queSoy(){
        return "PajaroNoCantor";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }
}
