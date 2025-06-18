package objetos;
import personas.Cliente;
import objetos.Prenda;

public class Tienda {

    public static void main(String[] args) {
        //solo mainn
        double impuesto = 0.2;
        double montoFinal = 0.0;
        
        Customer c = new Customer();

        c.name="Nardo";
        c.size="L";
        

        Cliente cliente1 = new Cliente();
        cliente1.setNombreCompleto("Juan luis");
        System.out.println("Bienvenido " + cliente1.getNombreCompleto());
        System.out.println("El precio minimo es: " + prenda.min_prize);

        Prenda prenda1 = new Prenda("remera akd", 20.9, "M");
        Prenda prenda2 = new Prenda("buzo rc style", 10.5, "S");
        Prenda prenda3 = new Clothing("Green Scarf",5.0,"S");
        Prenda prenda4 = new Clothing("Blue T-Shirt",10.5,"S");
        prenda[] prendas = {prenda1, prenda2, prenda3,prenda4}
        //System.out.println("Detalles de la prenda 1: " + prenda1.getDetalles() + " " + prenda1.getCosto() + " " + prenda1.getTalla());
        //System.out.println("Detalles de la prenda 2: " + prenda2.getDetalles() + " " + prenda2.getCosto() + " " + prenda2.getTalla());

        //montoFinal = ((prenda2.getCosto() * 2) + prenda1.getCosto()) * (1 + impuesto);
        //System.out.println("Total con impuesto: " + montoFinal);
        int measurement = 2;
        c.setSize(measurement);
        /*
        switch (measurement){
            case 1: case 2: case 3:
                c.size = "S";
                break;
            case 4: case 5:case 6:
                c.size="M";
                break;
            case 7: case 8: case 9:
                c.size="L";
                break;
            deafult:
                c.size="X";        
        */

        }
        for (Prenda prenda : prendas){
            System.out.println("Detalles de la prenda: " + prenda.getDetalles() + " " + prenda.getCosto() + " " + prenda.getTalla());    
            sout("item: "+ prenda);

            }
            // modificacion para el otro ej solo los q son de la talle del customer c
            //montoFinal += prenda.getCosto;
            //System.out.println("Detalles de la prenda: " + prenda.getDetalles() + " " + prenda.getCosto() + " " + prenda.getTalla());
        
        System.out.println("Total con impuesto: " + montoFinal);
        
    
}
