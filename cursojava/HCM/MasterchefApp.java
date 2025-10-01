package EJ1;

import segundoCuatri.ControlCalorias.Ingrediente;
import segundoCuatri.arcoyflecha.Color;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class MasterchefApp {
    public static void main(String[] args) {

        // --- Crear ingredientes ---
        Ingrediente pollo = new Ingrediente("Pollo", 200);
        Ingrediente tomate = new Ingrediente("Tomate", 50);
        Ingrediente cebolla = new Ingrediente("Cebolla", 40);

        HashSet<Ingrediente> ingredientesPlato = new HashSet<>();
        ingredientesPlato.add(pollo);
        ingredientesPlato.add(tomate);

        // --- Plato de ejemplo ---
        PlatoRepaso platoPrincipal = new PlatoRepaso(
                "Pollo al horno",
                ingredientesPlato,
                500,
                "Gonzalez",
                LocalDate.of(2024, 5, 10),
                "Buenos Aires",
                Color.ROJO,
                60
        );

        // --- Ingredientes prohibidos y stock ---
        HashSet<Ingrediente> prohibidos = new HashSet<>();
        prohibidos.add(cebolla);

        HashMap<Ingrediente, Integer> stock = new HashMap<>();
        stock.put(pollo, 2);
        stock.put(tomate, 5);
        stock.put(cebolla, 0);

        // --- Participantes ---
        Principiante prin = new Participante("Ana", 20, "Perez", "Calle Falsa 123", prohibidos, stock);
        Intermedio inter = new Participante("Luis", 25, "Martinez", "Av. Siempreviva 742", prohibidos, stock);
        Experto exp = new Participante("Marta", 30, "Lopez", "San Martin 456");

        // --- Mostrar mensajes y pruebas ---
        System.out.println("=== PRINCIPIANTE ===");
        prin.mensaje();
        prin.servirEntrada(platoPrincipal);

        System.out.println("\n=== INTERMEDIO ===");
        inter.mensaje();
        inter.servirPrincipal(platoPrincipal);

        System.out.println("\n=== EXPERTO ===");
        exp.mensaje();
        exp.servirPrincipal(platoPrincipal);
    }
}
