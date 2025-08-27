package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Dueño dueño1 = new Dueño("Matias", 17, "Faya", null);
        Dueño dueño2 = new Dueño("Adrian Emanuel", 32, "Martinez", null);


        HashMap<Integer, HashMap<Month, Consumo>> registroCasa = new HashMap<>();
        HashMap<Integer, HashMap<Month, Consumo>> registroDepto = new HashMap<>();


        Casa casa = new Casa("tamborini 3574", 1406, dueño1, registroCasa, 120, 50);
        Departamento depto = new Departamento("Av. vivaperon 1974", 1408, dueño2, registroDepto, 3);


        HashSet<Vivienda> viviendas = new HashSet<>();
        viviendas.add(casa);
        viviendas.add(depto);


        SistemaViviendas sistema = new SistemaViviendas(viviendas);


        LocalDate fecha1 = LocalDate.of(2024, Month.JANUARY, 1);
        LocalDate fecha2 = LocalDate.of(2025, Month.JANUARY, 1);


        casa.cargarConsumo(fecha1, 200);
        casa.cargarConsumo(fecha2, 180);


        depto.cargarConsumo(fecha1, 100);
        depto.cargarConsumo(fecha2, 120);


        System.out.println("FACTURACIÓN");
        for (Vivienda v : viviendas) {
            double subtotal = v.calcularSubtotal(fecha2);
            double total = v.calcularTotal(fecha2);
            System.out.println("Vivienda en: " + v.getDireccion());
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Total (con posible descuento): $" + total);
        }

    }
}
