package RepasoRecuperatorio2;

public interface Vendible {
    boolean actualizarStock(int cantidad)throws stockInsuficienteException;
    String descripcionVenta();
    double calcularPrecio(int cantidad);
    double vender(int cantidad);
}
