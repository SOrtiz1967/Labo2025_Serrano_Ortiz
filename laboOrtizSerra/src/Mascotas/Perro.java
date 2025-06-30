package Mascotas;

import personas.Persona;

public class Perro extends Mascota{
    public Perro() {
        super();
    }

    public Perro(String nombre, Persona duenio) {
        super(nombre, duenio);
    }

    @Override
    public String Saludo(){
        return "guau";
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
        return "Perro";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }
}
