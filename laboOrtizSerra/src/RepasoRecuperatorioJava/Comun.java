package RepasoRecuperatorioJava;

import java.util.HashSet;

public class Comun extends Carta implements Jugable{
    public static Double elixir=3.0;

    public static Double getElixir() {
        return elixir;
    }

    public static void setElixir(Double elixir) {
        Comun.elixir = elixir;
    }

    public Comun(String nombre, double danio, double vida, Arena arenaDesbloqueo) {
        super(nombre, danio, vida, arenaDesbloqueo);
    }

    public Comun() {
        super();
    }

    @Override
    public void frase(){
        System.out.println("soy una carta comun y mi costo de elixir es: "+Comun.elixir);
    }
    public HashSet<Double> valoresAtributos(){
        HashSet<Double> valoresAtributos= new HashSet<>();
        valoresAtributos.add(Comun.elixir);
        valoresAtributos.add(this.getDanio());
        valoresAtributos.add(this.getVida());
        return valoresAtributos;
    }
    @Override
    public void invocarCarta(int elixir)throws SinElixirException{
        if(Comun.elixir>elixir){
            throw new SinElixirException("No hay elixir suficiente");
        }
        System.out.println("Elixir suficiente para que esta carta sea usada");
    }
    @Override
    public String descripcionCarta(){
        return "Soy una carta común pero no por eso soy débil!";
    }
    public void recibirDanio(double danioRecibido){
        if(danioRecibido<this.getVida()){
            this.setVida(getVida()-danioRecibido);
            System.out.println("sigo en combate hasta el final!");
        }
        else{
            System.out.println("mori en batalla protegiendo a mi rey!");
        }
    }
    @Override
    public void evolucionarCarta(double vidaExtra){
        this.setVida(getVida()+vidaExtra);
    }
}
