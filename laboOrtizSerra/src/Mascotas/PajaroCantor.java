package Mascotas;

import primerCuatri.probar.personas.Persona;

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
            int aux=this.getAlegria();
            String saludo=this.canto;
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
        return "PajaroCantor";
    }
    public boolean estoyMuerto(){
        return false;
    }
    public void alimentar(){
        this.setAlegria(this.getAlegria()+1);
    }
}
