package RepasoRecuperatorio2;

import java.util.HashMap;

public class Brownie extends Preparacion implements Vendible{
    private int cantidadChocolate;

    public int getCantidadChocolate() {
        return cantidadChocolate;
    }

    public void setCantidadChocolate(int cantidadChocolate) {
        this.cantidadChocolate = cantidadChocolate;
    }

    public Brownie(HashMap<String, Integer> cantidadIngrediente, int stock, double precio, String receta, int cantidadChocolate) {
        super(cantidadIngrediente, stock, precio, receta);
        this.cantidadChocolate = cantidadChocolate;
        this.agregarIngredienteEspecial();
    }

    public Brownie() {
        super();
        this.cantidadChocolate=0;
        this.agregarIngredienteEspecial();
    }

    @Override
    public void agregarIngredienteEspecial(){
        super.getCantidadIngrediente().put("chocolate",cantidadChocolate);
    }
    public String conocerReceta(){
        return "Derretí la manteca "+ super.getReceta();
    }
    @Override
    public boolean actualizarStock(int c)throws stockInsuficienteException{
        if(super.getStock()<c){
            throw new stockInsuficienteException("No hay stock suficiente");
        }
        System.out.println("Stock suficiente");
        super.restarStock(c);
        return true;
    }
    @Override
    public String descripcionVenta(){
        return "Brownies bien húmedos";
    }
    @Override
    public double calcularPrecio(int  c){
        double precio= super.getPrecio()*c;
        System.out.println("El precio es: "+precio);
        return precio;
    }
    @Override
    public double vender(int c){
        try{
            this.actualizarStock(c);
        } catch (stockInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        return this.calcularPrecio(c);
    }
}
