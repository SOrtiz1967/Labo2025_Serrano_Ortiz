package sistemas;

import consumibles.Bebida;
import personas.Tomador;

import java.util.ArrayList;

public class SistemaTomadores {
    private ArrayList<Tomador> tomadores;
    private ArrayList<Bebida> bebidas;



    public void agregarTomador(Tomador t) {
        tomadores.add(t);
    }

    public void agregarBebida(Bebida b) {
        bebidas.add(b);
    }

    public Tomador cMejorTomador(){
        Tomador mejor=tomadores.get(0);

        for(Tomador t : tomadores){
            if(t.calcularCoeficienteHidratacion()>mejor.calcularCoeficienteHidratacion()){
                mejor=t;
            }
        }
        return mejor;
    }
    public Tomador cPeorTomador(){
        Tomador peor=tomadores.get(0);

        for(Tomador t : tomadores){
            if(t.calcularCoeficienteHidratacion()<peor.calcularCoeficienteHidratacion()){
                peor=t;
            }
        }
        return peor;
    }
    // método para que el usuario elija que bebida consumir y la cantidad.
    public void userInteract(){
        
    }




}
