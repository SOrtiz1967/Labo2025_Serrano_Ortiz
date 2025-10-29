package RepasoRecuperatorioJava;

import java.util.HashMap;
import java.util.HashSet;

public class PoliRoyaleApp {
    private HashSet<Carta>cartas;
    private HashSet<Jugable>jugables;
    private HashMap<Jugador,Carta> jugadoresConCartaPreferida;

    public HashSet<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(HashSet<Carta> cartas) {
        this.cartas = cartas;
    }

    public HashSet<Jugable> getJugables() {
        return jugables;
    }

    public void setJugables(HashSet<Jugable> jugables) {
        this.jugables = jugables;
    }

    public HashMap<Jugador, Carta> getJugadoresConCartaPreferida() {
        return jugadoresConCartaPreferida;
    }

    public PoliRoyaleApp(HashSet<Carta> cartas, HashSet<Jugable> jugables, HashMap<Jugador, Carta> jugadoresConCartaPreferida) {
        this.cartas = cartas;
        this.jugables = jugables;
        this.jugadoresConCartaPreferida = jugadoresConCartaPreferida;
    }

    public PoliRoyaleApp() {
        this.cartas = new HashSet<>();
        this.jugables = new HashSet<>();
        this.jugadoresConCartaPreferida = new HashMap<>();
    }

    public void setJugadoresConCartaPreferida(HashMap<Jugador, Carta> jugadoresConCartaPreferida) {
        this.jugadoresConCartaPreferida = jugadoresConCartaPreferida;
    }

    public String cartafav(Jugador jugador, Carta cartafav)throws CartaFavoritaRepetidaException{
        if(jugadoresConCartaPreferida.containsKey(jugador)){
            if(jugadoresConCartaPreferida.get(jugador).equals(cartafav)){
                throw new CartaFavoritaRepetidaException("Ya tenia esta carta asignada como favorita");
            }
            jugadoresConCartaPreferida.remove(jugador);
            jugadoresConCartaPreferida.put(jugador,cartafav);//aca estaria bueno hacerlo en un metodo tmb
            return "carta favorita registrada con exito";
        }
        return "no estas registrado en la base de datos";
    }
    public void nuevaCarta(Carta carta)throws ValoresNegativosException{
        for(Double valorAtributo:carta.valoresAtributos()){
            if(valorAtributo<0){
                throw new ValoresNegativosException("Carta con valores inválidos");
            }
        }
        this.cartas.add(carta);
        System.out.println("se ha agregado correctamente la carta");
    };
    public String subirNivel(Jugable cartaJugable, Double valorVidaSumada){
        cartaJugable.evolucionarCarta(valorVidaSumada);
        try{
        Carta c= (Carta) cartaJugable;
        String vida=  String.valueOf(c.getVida());;
            return "La carta ha sido reforzada correctamente, mi nueva vida es: " + vida;} catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }
    public HashMap<Integer,String> cartasJugables(){
        HashMap<Integer,String> cartasJugables = new HashMap<>();
        String jugables= String.valueOf(this.jugables.size());
        cartasJugables.put(this.jugables.size(),"La cantidad de cartas jugables son: "+ jugables);
        return cartasJugables;
    }

    public static void main(String[] args) {
        Carta c1= new Comun("espiritu de hielo",40.0,20.0,Arena.BUFFET);
        Carta c2= new Especial("espiritu de sanacion",70.0,-10.0,Arena.LABO,3.0,2.0,2.0);
        Carta c3= new Epica("espiritu de fuego",100.0,30.0,Arena.CUARTITODENESTOR,1.0);
        Carta cartadefault= new Comun();
        Jugador j1= new Jugador("benja",321,"storm",12,Arena.CUARTITODENESTOR);
        PoliRoyaleApp a1=new PoliRoyaleApp();
        HashSet<Carta>cartas=new HashSet<>();
        cartas.add(c1);
        cartas.add(c2);
        cartas.add(c3);
        for(Carta c: cartas){
            c.frase();
            try{a1.nuevaCarta(c);} catch (ValoresNegativosException e) {
                System.out.println(e.getMessage());
            }
            try{Jugable j=(Jugable)c;
                a1.jugables.add(j);}
            catch (ClassCastException e){
                System.out.println(e.getMessage());
            }
        }
        a1.jugadoresConCartaPreferida.put(j1,cartadefault);
        try {
            System.out.println(a1.cartafav(j1,c2));
        } catch (CartaFavoritaRepetidaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a1.cartasJugables().get(a1.jugables.size()));
        for (Jugable j: a1.jugables){
            System.out.println(a1.subirNivel(j,3.0));
            j.evolucionarCarta(2.0);
            System.out.println(j.descripcionCarta());
            try{j.invocarCarta(2);} catch (SinElixirException e) {
                System.out.println(e.getMessage());
            }
            j.recibirDanio(20.0);
        }

    }
}
