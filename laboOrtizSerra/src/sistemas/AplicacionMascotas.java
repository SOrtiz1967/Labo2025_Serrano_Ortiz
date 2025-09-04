package sistemas;

import primerCuatri.probar.Mascotas.*;
import primerCuatri.probar.personas.Persona;

import java.util.ArrayList;

public class AplicacionMascotas {
    private ArrayList<Mascota> mascotas;
    private ArrayList<Persona> usuarios;

    public AplicacionMascotas(ArrayList<Mascota> mascotas,ArrayList<Persona> usuarios) {
        this.mascotas = mascotas;
    }

    public AplicacionMascotas() {
        this.mascotas=new ArrayList<Mascota>();
        this.usuarios=new ArrayList<Persona>();
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public ArrayList<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarMascota(Mascota mascotaAgregada){
        this.mascotas.add(mascotaAgregada);
    }
    public void eliminarMascota(Mascota mascotaEliminada){
        this.mascotas.remove(mascotaEliminada);
    }
    public void modificarMascota(Mascota mascotaAgregada, Mascota mascotaEliminada){
        agregarMascota(mascotaAgregada);
        eliminarMascota(mascotaEliminada);
    }
    public void saludar(String nombreUsuario, String nombreMascota){
        for (Mascota m:this.mascotas){
            if(m.getNombre().equals(nombreMascota)){
                m.serSaludado(nombreUsuario);
                if(m.queSoy().equals("Pez")){
                    if(m.estoyMuerto()){
                        this.eliminarMascota(m);
                        System.out.println("El pez ha muerto :(");
                    }
                }
            }
        }
    }
    public void mascotaAlimentada(Mascota mascota){
        mascota.alimentar();
    }
    public static void main(String[] args) {
        AplicacionMascotas ap1= new AplicacionMascotas();
        Persona u1=new Persona("Matias",34,"Faya","villa maipu");
        ap1.usuarios.add(u1);
        Persona u2=new Persona();
        ap1.usuarios.add(u2);
        Mascota m1=new Pez("Tobias",u1);
        ap1.agregarMascota(m1);
        Mascota m2= new Perro("Juan",u2);
        ap1.agregarMascota(m2);
        Mascota m3=new PajaroCantor("Fran",u1,"iuiu");
        ap1.agregarMascota(m3);
        Mascota m4=new PajaroNoCantor("Lauty",u2);
        ap1.agregarMascota(m4);
        Mascota m5=new Gato("Lulo",u1);
        ap1.agregarMascota(m5);



        System.out.println("Saludos generales de todas las mascotas =");
        for (Mascota m : ap1.mascotas) {
            System.out.print(m.getNombre() + ": ");
            System.out.println(m.Saludo());
        }
        System.out.println("El usuario 1 saluda a Lauty");
        ap1.saludar(u1.getNombre(), m4.getNombre());
        System.out.println("El usuario 1 saluda a Lulo");
        ap1.saludar(u1.getNombre(), m5.getNombre());
        System.out.println("Se alimenta a Lauty");
        ap1.mascotaAlimentada(m4);

    }
}
