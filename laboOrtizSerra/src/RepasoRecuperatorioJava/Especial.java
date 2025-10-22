package RepasoRecuperatorioJava;

public class Especial extends Carta implements Jugable{
    private int nivelDesbloqueo;
    private int elixir;
    private int bonus;
    @Override
    public void frase(){
        System.out.println("soy una carta especial de nivel "+this.nivelDesbloqueo+" y mi costo actual de elixir actual es: "+this.elixir);
    }
    @Override
    public void invocarCarta(int elixir)throws SinElixirException{
        if(this.elixir>elixir){
            throw new SinElixirException("No hay elixir suficiente");
        }
        System.out.println("Elixir suficiente para que esta carta sea usada");
    }
    @Override
    public String descripcionCarta(){
        return "Soy una carta especial y puedo contra todo!";
    }
    @Override
    public void recibirDanio(double danioRecibido){
        if(danioRecibido<this.getVida()){
            this.setVida(getVida()-danioRecibido);//esto esta mejor hacer un metodo en carta que sea modificar vidad
            System.out.println("sigo en combate hasta el final!");
        }
        else{
            System.out.println("mori en batalla protegiendo a mi rey!");
        }
    }
    @Override
    public void evolucionarCarta(double vidaExtra){
        this.setVida(getVida()+vidaExtra);
        this.bonus+=2;
    }
}
