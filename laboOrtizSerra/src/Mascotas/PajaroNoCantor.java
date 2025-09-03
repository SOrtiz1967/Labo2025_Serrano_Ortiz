package Mascotas;

import primerCuatri.probar.personas.Persona;

public class PajaroNoCantor extends Mascota{

    public PajaroNoCantor(String nombre, Persona duenio) {
        super(nombre, duenio);

    }

    public PajaroNoCantor() {
        super();
    }

    @Override
    public String Saludo(){
            int aux=this.getAlegria();
            String saludo="pio";
            if(this.getAlegria()>1) {
                while (aux > 0) {
                    saludo+=saludo;
                    aux--;
                }
                this.setAlegria(this.getAlegria() - 1);

            }
            if(this.getAlegria()>=0){
                return saludo;
            }
            return "";
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
        return "PajaroNoCantor";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }
}
