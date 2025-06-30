package Mascotas;

import personas.Persona;

public class Gato extends Mascota{
    public Gato(String nombre, Persona duenio) {
        super(nombre, duenio);
    }
    public Gato() {
        super();
    }

    @Override
    public String Saludo(){
        return "miau";
    }
    public void serSaludado(String nombreUsuario){
        if(this.getDuenio().getNombre().equals(nombreUsuario)){
            System.out.println(this.Saludo());
        }
        else {
            System.out.println(this.Saludo().toUpperCase()+"!");
        }
    }
    public String queSoy(){
        return "Gato";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }

}
