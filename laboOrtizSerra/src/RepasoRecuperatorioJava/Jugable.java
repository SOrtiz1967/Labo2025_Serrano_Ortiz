package RepasoRecuperatorioJava;

public interface Jugable {
    void invocarCarta(int elixirJugador)throws SinElixirException;
    String descripcionCarta();
    void recibirDanio(double danioRecibido);
    void evolucionarCarta(double vidaExtra);

}
