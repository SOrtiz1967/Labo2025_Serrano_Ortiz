package RepasoRecuperatorio2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DesayunoApp {
    private HashSet<Preparacion> preparaciones;
    private HashSet<Vendible> vendibles;
    private HashMap<Vendible,Integer> ventas;

    public HashSet<Preparacion> getPreparaciones() {
        return preparaciones;
    }

    public void setPreparaciones(HashSet<Preparacion> preparaciones) {
        this.preparaciones = preparaciones;
    }

    public HashSet<Vendible> getVendibles() {
        return vendibles;
    }

    public void setVendibles(HashSet<Vendible> vendibles) {
        this.vendibles = vendibles;
    }

    public HashMap<Vendible, Integer> getVentas() {
        return ventas;
    }

    public void setVentas(HashMap<Vendible, Integer> ventas) {
        this.ventas = ventas;
    }

    public DesayunoApp(HashSet<Preparacion> preparaciones, HashSet<Vendible> vendibles, HashMap<Vendible, Integer> ventas) {
        this.preparaciones = preparaciones;
        this.vendibles = vendibles;
        this.ventas = ventas;
    }

    public DesayunoApp() {
        this.preparaciones = new HashSet<>();
        this.vendibles = new HashSet<>();
        this.ventas = new HashMap<>();
    }

    public void registrarVenta(Vendible v, int c)throws stockInsuficienteException{
        v.actualizarStock(c);
        System.out.println("Venta cargada con éxito");
        this.ventas.put(v,c);
    }
    public void nuevaPreparacion(Preparacion p)throws IngredienteException{
        for (int c:p.getCantidadIngrediente().values()){
            if(c<0){
                throw new IngredienteException("Ingrediente con cantidades inválidas");
            }
        }
        System.out.println("Se ha agregado correctamente la preparación");
        this.preparaciones.add(p);
        try{
            Vendible v=(Vendible) p;
            this.vendibles.add(v);
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
    public String reponerProducto(Preparacion p,int c){
        if(c>0){
            p.sumarStock(c);
            return "El stock nuevo es de: "+ String.valueOf(p.getStock());
        }
        else{
            return "valor invalido";
        }
    }
    public int productosVendibles(){
        System.out.println("La cantidad de productos que estan a la venta son: "+ this.vendibles.size());
        return this.vendibles.size();
    }

    public static void main(String[] args) {
        Preparacion p1= new Bizcochuelo();
    }
}
