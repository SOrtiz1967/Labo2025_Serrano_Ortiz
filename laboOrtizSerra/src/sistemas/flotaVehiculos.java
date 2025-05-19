package sistemas;

import vehiculo.Bicicleta;
import vehiculo.Camioneta;
import vehiculo.Coche;

import java.util.ArrayList;

public class flotaVehiculos {
    private ArrayList<Coche> coches;
    private ArrayList<Camioneta> chatas;
    private ArrayList<Bicicleta> naves;

    public flotaVehiculos(ArrayList<Coche> coches, ArrayList<Camioneta> chatas, ArrayList<Bicicleta> naves) {
        this.coches = coches;
        this.chatas = chatas;
        this.naves = naves;
    }
    public flotaVehiculos(){
        this.coches = new ArrayList<>();
        this.chatas= new ArrayList<>();
        this.naves = new ArrayList<>();
    }
    public void masCantidad(){
        int auti= coches.size();
        int camios= chatas.size();
        int nave= naves.size();
        if (auti>camios && auti>nave){
            System.out.println("tenes mas autos!");

        }
        if (auti<camios && camios>nave){
            System.out.println("tenes mas camionetas!");

        }
        if (nave>camios && auti<nave){
            System.out.println("tenes mas bicis amigo!");

        }

    }
    public double descapotables(){
        int aux=0;
        for(Coche c : coches){
            if (c.getDescapotable()){
                aux++;
            }
        }
        int i = (coches.size() / aux) * 100;
        return i;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public ArrayList<Camioneta> getChatas() {
        return chatas;
    }

    public void setChatas(ArrayList<Camioneta> chatas) {
        this.chatas = chatas;
    }

    public ArrayList<Bicicleta> getNaves() {
        return naves;
    }

    public void setNaves(ArrayList<Bicicleta> naves) {
        this.naves = naves;
    }

    public static void main(String[] args) {
        
    }

}
