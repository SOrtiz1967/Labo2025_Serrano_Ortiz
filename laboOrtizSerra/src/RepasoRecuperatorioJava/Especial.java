package RepasoRecuperatorioJava;

import java.util.HashSet;

public class Especial extends Carta implements Jugable{
    private double nivelDesbloqueo;
    private double elixir;
    private double bonus;

    public double getNivelDesbloqueo() {
        return nivelDesbloqueo;
    }

    public void setNivelDesbloqueo(double nivelDesbloqueo) {
        this.nivelDesbloqueo = nivelDesbloqueo;
    }

    public double getElixir() {
        return elixir;
    }

    public void setElixir(double elixir) {
        this.elixir = elixir;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Especial(String nombre, double danio, double vida, Arena arenaDesbloqueo, double nivelDesbloqueo, double elixir, double bonus) {
        super(nombre, danio, vida, arenaDesbloqueo);
        this.nivelDesbloqueo = nivelDesbloqueo;
        this.elixir = elixir;
        this.bonus = bonus;
    }

    public Especial() {
        super();
        this.nivelDesbloqueo = 0;
        this.elixir = 0;
        this.bonus = 0;
    }

    @Override
    public void frase(){
        System.out.println("soy una carta especial de nivel "+this.nivelDesbloqueo+" y mi costo de elixir actual es: "+this.elixir);
    }
    public HashSet<Double> valoresAtributos(){
        HashSet<Double> valoresAtributos= new HashSet<>();
        valoresAtributos.add(this.elixir);
        valoresAtributos.add(this.bonus);
        valoresAtributos.add(bonus);
        valoresAtributos.add(this.getDanio());
        valoresAtributos.add(this.getVida());
        return valoresAtributos;
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
