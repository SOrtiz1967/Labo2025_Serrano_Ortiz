package primerCuatri.probar.objetos;

import java.util.ArrayList;

public class RecetaEntrada extends Receta {
    private Temperatura temperatura;

    public RecetaEntrada(String nombre, Dificultad dificultad, ArrayList<String> listadepasos, Temperatura temperatura) {
        super(nombre, dificultad, listadepasos);
        this.temperatura = temperatura;
    }

    public RecetaEntrada() {
        super();
        this.temperatura = Temperatura.FRIO;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    void MostrarReceta() {
        System.out.println("Los pasos a seguir son: ");
        int i = 0;
        if (this.temperatura == Temperatura.FRIO) {
            for (String paso : super.getListadepasos()) {
                System.out.println("Paso" + i + ":" + paso);
                i++;
            }
            System.out.println("Recordar guardar la preparacion en la heladera.");
        }
        if (this.temperatura == Temperatura.CALIENTE) {
            System.out.println("Recordar prender el horno previamente a los pasos.");
            for (String paso : super.getListadepasos()) {
                System.out.println("Paso" + i + ":" + paso);
                i++;
            }
        }
    }
    /*@Override
    void Tipo(){
        RecetaEntrada.class.getName();
    }*/
}
