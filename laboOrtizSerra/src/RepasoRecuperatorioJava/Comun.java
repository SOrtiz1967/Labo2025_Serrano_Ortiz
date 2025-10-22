package RepasoRecuperatorioJava;

public class Comun extends Carta implements Jugable{
    public static int elixir=3;
    @Override
    public void frase(){
        System.out.println("soy una carta comun y mi costo actual de elixir es: "+Comun.elixir);
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
