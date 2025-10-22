package RepasoRecuperatorioJava;

import java.util.HashMap;
import java.util.HashSet;

public class PoliRoyaleApp {
    private HashSet<Carta>cartas;
    private HashSet<Jugable>jugables;
    private HashMap<Jugador,Carta> jugadoresConCartaPreferida;
    public String cartafav(Jugador jugador, Carta cartafav)throws CartaFavoritaRepetidaException{
        if(jugadoresConCartaPreferida.containsKey(jugador)){
            if(jugadoresConCartaPreferida.get(jugador).equals(cartafav)){
                throw new CartaFavoritaRepetidaException("Ya tenia esta carta asignada como favorita");
            }
            jugadoresConCartaPreferida.remove(jugador);
            jugadoresConCartaPreferida.put(jugador,cartafav);//aca estaria bueno hacerlo en un metodo tmb
            return "carta favorita registrada con exito";
        }
    };
    nuevaCarta();
    subirNivel();
    cartaJugable();
}
