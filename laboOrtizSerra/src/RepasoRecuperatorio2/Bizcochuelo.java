package RepasoRecuperatorio2;

import java.util.HashMap;

public class Bizcochuelo extends Preparacion{
    private int cantidadLimon;
    private int PolvoHornear;

    public int getCantidadLimon() {
        return cantidadLimon;
    }

    public void setCantidadLimon(int cantidadLimon) {
        this.cantidadLimon = cantidadLimon;
    }

    public int getPolvoHornear() {
        return PolvoHornear;
    }

    public void setPolvoHornear(int polvoHornear) {
        PolvoHornear = polvoHornear;
    }

    public Bizcochuelo(HashMap<String, Integer> cantidadIngrediente, int stock, double precio, String receta, int cantidadLimon, int polvoHornear) {
        super(cantidadIngrediente, stock, precio, receta);
        this.cantidadLimon = cantidadLimon;
        PolvoHornear = polvoHornear;
        this.agregarIngredienteEspecial();
    }

    public Bizcochuelo() {
        super();
        this.cantidadLimon = 0;
        PolvoHornear = 0;
        this.agregarIngredienteEspecial();
    }

    @Override
    public void agregarIngredienteEspecial(){
        super.getCantidadIngrediente().put("limon",cantidadLimon);
        super.getCantidadIngrediente().put("polvo de hornear",PolvoHornear);
    }
    public String conocerReceta(){
        return "El bizcochuelo arranca con "+ super.getReceta();
    }
}
