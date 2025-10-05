package EJ1;

import primerCuatri.probar.personas.Persona;
import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.arcoyflecha.Color;

import java.util.HashMap;
import java.util.HashSet;

public class MasterChefApp {
    private HashSet<Participante> chefs;
    private HashSet<PlatoRepaso> platos;

    public MasterChefApp(HashSet<Participante> chefs, HashSet<PlatoRepaso> platos){
        this.chefs=chefs;
        this.platos=platos;
    }

    public HashSet<Participante> getChefs() {
        return chefs;
    }

    public void setChefs(HashSet<Participante> chefs) {
        this.chefs = chefs;
    }

    public HashSet<PlatoRepaso> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<PlatoRepaso> platos) {
        this.platos = platos;
    }
    public static void main(String[] args) {
        MasterChefApp sistema = new MasterChefApp(new HashSet<>(), new HashSet<>());
        Ingrediente i1=new Ingrediente("raviol",40);
        Ingrediente i2=new Ingrediente("salsa cacarola",2);
        Ingrediente i3=new Ingrediente("carne",60);
        Ingrediente i4=new Ingrediente("papa",40);
        HashSet<Ingrediente>ingredientespl1=new HashSet<>();
        HashSet<Ingrediente>ingredientespl2=new HashSet<>();
        HashMap<Ingrediente,Integer>prohibidos=new HashMap<>();
        prohibidos.put(i1,4);
        prohibidos.put(i3,2);
        ingredientespl1.add(i1);
        ingredientespl1.add(i2);
        ingredientespl2.add(i3);
        ingredientespl2.add(i4);
        PlatoRepaso pl1=new PlatoRepaso("ravioles a la cacarola",ingredientespl1,42,40);
        PlatoRepaso pl2=new PlatoRepaso("pastel de papa",ingredientespl2,100,60);
        Principiante pa1= new Principiante("Santiago",18,"ortiz","burela 123", Color.ROJO,ingredientespl2);
        Intermedio pa2= new Intermedio("javier",50,"ortiz","burela 1234", Color.AZUL,prohibidos);
        Experto pa3= new Experto("Corina",40,"ortiz","burela 1234", Color.VERDE);
        sistema.chefs.add(pa1);
        sistema.chefs.add(pa2);
        sistema.chefs.add(pa3);
        sistema.platos.add(pl1);
        sistema.platos.add(pl2);
        System.out.println("Preparar zona de trabajo");
        for(Participante p: sistema.chefs){
            p.mensaje();
        }
        try {
            pa1.servirEntrada(pl1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            pa3.servirEntrada(pl1);
            pa3.servirPrincipal(pl2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            pa2.servirPrincipal(pl2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    }

