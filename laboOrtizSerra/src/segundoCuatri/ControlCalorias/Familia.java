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
        HashSet<String>ingredientes= new HashSet<>();
        HashSet<String>ingredientes2= new HashSet<>();
        ingredientes2.add("Papa");
        ingredientes2.add("huevo");
        ingredientes.add("Conejo");
        ingredientes.add("zanahoria");
        Plato p1=new Plato("Conejo con zanahoria",ingredientes,510);
        Plato p2=new Plato("Tortilla de papa",ingredientes2,600);
        HashSet<String> ingredientes3 = new HashSet<>();
        HashSet<String> ingredientes4 = new HashSet<>();
        ingredientes3.add("Pollo");
        ingredientes3.add("arroz");
        ingredientes4.add("Tomate");
        ingredientes4.add("mozzarella");
        ingredientes4.add("albahaca");
        Plato p3 = new Plato("Pollo con arroz", ingredientes3, 700);
        Plato p4 = new Plato("Ensalada caprese", ingredientes4, 350);
        HashMap<Plato,Integer> platos= new HashMap<>();
        HashMap<Plato,Integer> platos2= new HashMap<>();
        platos.put(p1,p1.getCalorias());
        platos.put(p2,p2.getCalorias());
        platos2.put(p3, p3.getCalorias());
        platos2.put(p4, p4.getCalorias());
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
