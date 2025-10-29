package RepasoRecuperatorio2;

import java.util.HashMap;

public class Cookie extends Preparacion implements Vendible{
    private int cantidadBicarbonato;
    private Topping topping;

    public int getCantidadBicarbonato() {
        return cantidadBicarbonato;
    }

    public void setCantidadBicarbonato(int cantidadBicarbonato) {
        this.cantidadBicarbonato = cantidadBicarbonato;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Cookie(HashMap<String, Integer> cantidadIngrediente, int stock, double precio, String receta, int cantidadBicarbonato, Topping topping) {
        super(cantidadIngrediente, stock, precio, receta);
        this.cantidadBicarbonato = cantidadBicarbonato;
        this.topping = topping;
        this.agregarIngredienteEspecial();
    }

    public Cookie() {
        super();
        this.cantidadBicarbonato=0;
        this.topping=Topping.NUTELLA;
        this.agregarIngredienteEspecial();
    }

    @Override
    public void agregarIngredienteEspecial(){
        super.getCantidadIngrediente().put("bicarbonato",cantidadBicarbonato);
    }
    public String conocerReceta(){
        return "Empeza partiendo el chocolate "+ super.getReceta();
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
        return "Animate a probar las mejores cookies del mercado";
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
