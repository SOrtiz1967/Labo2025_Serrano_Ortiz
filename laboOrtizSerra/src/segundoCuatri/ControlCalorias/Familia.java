package segundoCuatri.ControlCalorias;

import personas.Persona;

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
}
