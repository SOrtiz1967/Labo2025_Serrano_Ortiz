package Mascotas;

import personas.Persona;

public class PajaroCantor extends Mascota {
    private String canto;

    public PajaroCantor(String nombre, Persona duenio, String canto) {
        super(nombre, duenio);
        this.canto = canto;
    }

    public PajaroCantor(){
        super();
        this.canto="";
    }

    public String getCanto() {
        return canto;
    }

    public void setCanto(String canto) {
        this.canto = canto;
    }
    @Override
    public String Saludo(){
        return this.canto;
    }
    public void serSaludado(String nombreUsuario){
        if(this.getDuenio().getNombre().equals(nombreUsuario)){
            System.out.println(this.Saludo());
        }
    }
    public String queSoy(){
        return "PajaroCantor";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }
}
