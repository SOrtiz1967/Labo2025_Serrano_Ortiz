package ejercicioBebidas;

public class Main {
    public static void main(String[] args) {
        Bebida coca= new BebidasAzucaradas();
        Bebida champeta= new BebidaAlcoholica();
        Tomador alcoholico=new Tomador();
        Consumicion c1= new Consumicion(champeta, 6);
        Consumicion c2= new Consumicion(coca, 2);
        alcoholico.agregarConsumo(c1);
        alcoholico.agregarConsumo(c2);
        System.out.println(coca.);
    }
}
