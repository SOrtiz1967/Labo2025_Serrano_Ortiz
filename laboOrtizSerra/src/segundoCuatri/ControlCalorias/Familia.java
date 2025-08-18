package segundoCuatri.ControlCalorias;

import personas.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Familia {
    private HashSet<MiembroFamiliar> integrantes;

    public Familia(HashSet<MiembroFamiliar> integrantes) {
        this.integrantes = integrantes;
    }

    public Familia() {
        this.integrantes = new HashSet<>();
    }

    public HashSet<MiembroFamiliar> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(HashSet<MiembroFamiliar> integrantes) {
        this.integrantes = integrantes;
    }
    public int promedio(){
        int caloriasxfamilia=0;
        int cantidadFamiliares=this.integrantes.size();
        for(MiembroFamiliar m:this.integrantes){
            for(Map.Entry<Plato,Integer> p:m.getPlatoconcalorias().entrySet()){
                caloriasxfamilia+=p.getValue();
            }
        }
        caloriasxfamilia/=cantidadFamiliares;
        return caloriasxfamilia;
    }
    public MiembroFamiliar masComio(){
        MiembroFamiliar comilon=new MiembroFamiliar();
        int cantidadMayor=0;
        int cantidadCalorias=0;
        for(MiembroFamiliar m:this.integrantes){
            for(Map.Entry<Plato,Integer> p:m.getPlatoconcalorias().entrySet()){
                cantidadCalorias++;
            }
            if(cantidadCalorias>cantidadMayor){
                cantidadMayor=cantidadCalorias;
                comilon=m;
            }
        }
        return comilon;
    }
    public MiembroFamiliar menosComio(){
        MiembroFamiliar flaquito=new MiembroFamiliar();
        int cantidadMenor=100000;
        int cantidadCalorias=0;
        for(MiembroFamiliar m:this.integrantes){
            for(Map.Entry<Plato,Integer> p:m.getPlatoconcalorias().entrySet()){
                cantidadCalorias++;
            }
            if(cantidadCalorias<cantidadMenor){
                cantidadMenor=cantidadCalorias;
                flaquito=m;
            }
        }
        return flaquito;
    }

    public static void main(String[] args) {
        HashSet<Ingrediente>ingredientes= new HashSet<>();
        HashSet<Ingrediente>ingredientes2= new HashSet<>();
        Ingrediente i1=new Ingrediente("Papa",20);
        Ingrediente i2=new Ingrediente("huevo",80);
        Ingrediente i3=new Ingrediente("conejo",100);
        Ingrediente i4=new Ingrediente("zanahoria",120);
        ingredientes.add(i2);
        ingredientes.add(i1);
        ingredientes2.add(i3);
        ingredientes2.add(i4);
        Plato p1=new Plato("Conejo con zanahoria",ingredientes,510);
        Plato p2=new Plato("Tortilla de papa",ingredientes2,600);
        HashMap<Plato,Integer> platos= new HashMap<>();
        HashMap<Plato,Integer> platos2= new HashMap<>();
        platos.put(p1,p1.getCalorias());
        platos.put(p2,p2.getCalorias());
        MiembroFamiliar m1= new MiembroFamiliar("Matias",17,platos);
        MiembroFamiliar m2=new MiembroFamiliar("Santiago",18,platos2);
        HashSet<MiembroFamiliar> familiares = new HashSet<>();
        familiares.add(m1);
        familiares.add(m2);
        Familia f1= new Familia(familiares);
        //1
        System.out.println("Calorias consumidas por: " + m1.getNombre() + ": "+ m1.cantidadCalorias());
        System.out.println("Calorias consumidas por: " + m2.getNombre() + ": "+ m2.cantidadCalorias());
        //2
        System.out.println("El promedio de calorias de la familia es: "+ f1.promedio());
        //3
        System.out.println("El más comilón es: "+ f1.masComio().getNombre());
        //4
        System.out.println("El más flaquito es: "+ f1.menosComio().getNombre());
    }
}
