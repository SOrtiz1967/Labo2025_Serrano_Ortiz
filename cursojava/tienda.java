package objetos;
import personas.Cliente;
import objetos.Prenda;

public class Tienda {

    public static void main(String[] args) {
        //solo mainn
        double impuesto = 0.2;
        double montoFinal;

        Cliente cliente1 = new Cliente();
        cliente1.setNombreCompleto("Soleado");
        System.out.println("Bienvenido " + cliente1.getNombreCompleto());

        Prenda prenda1 = new Prenda("Sudadera Verde", 20.9, "M");
        Prenda prenda2 = new Prenda("Polo Amarillo", 10.5, "S");

        System.out.println("Detalles de la prenda 1: " + prenda1.getDetalles() + " " + prenda1.getCosto() + " " + prenda1.getTalla());
        System.out.println("Detalles de la prenda 2: " + prenda2.getDetalles() + " " + prenda2.getCosto() + " " + prenda2.getTalla());

        montoFinal = ((prenda2.getCosto() * 2) + prenda1.getCosto()) * (1 + impuesto);
        System.out.println("Total con impuesto: " + montoFinal);
    }
}
