package primerCuatri.probar.objetos;

import java.util.ArrayList;

public class RecetaPostre extends Receta {
    private int temperaturaDelHorno;
    private Apto aptodiabeticos;

    public RecetaPostre(String nombre, Dificultad dificultad, ArrayList<String> listadepasos, int temperaturaDelHorno, Apto aptodiabeticos) {
        super(nombre, dificultad, listadepasos);
        this.temperaturaDelHorno = temperaturaDelHorno;
        this.aptodiabeticos = aptodiabeticos;
    }

    public RecetaPostre() {
        super();
        this.aptodiabeticos = Apto.APTODIABETICOS;
        this.temperaturaDelHorno = 170;
    }

    public RecetaPostre(int temperaturaDelHorno, Apto aptodiabeticos) {
        this.temperaturaDelHorno = temperaturaDelHorno;
        this.aptodiabeticos = aptodiabeticos;
    }

    public int getTemperaturaDelHorno() {
        return temperaturaDelHorno;
    }

    public void setTemperaturaDelHorno(int temperaturaDelHorno) {
        this.temperaturaDelHorno = temperaturaDelHorno;
    }

    public Apto getAptodiabeticos() {
        return aptodiabeticos;
    }

    public void setAptodiabeticos(Apto aptodiabeticos) {
        this.aptodiabeticos = aptodiabeticos;
    }

    @Override
    void MostrarReceta() {
        System.out.println("Los pasos a seguir son: ");
        int i = 0;
        for (String paso : super.getListadepasos()) {
            System.out.println("Paso" + i + ":" + paso + "recordar mantener la cocina limpia y el horno al minimo entre cada paso");
            i++;
        }
    }
    /*@Override
    void Tipo(){
        RecetaPostre.class.getName();
    }*/
}
