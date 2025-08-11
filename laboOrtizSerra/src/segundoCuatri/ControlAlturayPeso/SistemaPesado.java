package segundoCuatri.ControlAlturayPeso;

import java.time.LocalDate;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class SistemaPesado {
    HashSet<Humano> personas;

    public HashSet<Humano> getPersonas() {
        return personas;
    }

    public void setPersonas(HashSet<Humano> personas) {
        this.personas = personas;
    }

    public SistemaPesado(HashSet<Humano> personas) {
        this.personas = personas;
    }

    public static void main(String[] args) {
        // Crear registro inicial para la persona
        HashMap<Datos, LocalDate> registroJuan = new HashMap<>();

        // Crear un humano
        Humano juan = new Humano(
                "Juan",
                "Pérez",
                LocalDate.of(2005, 5, 12),
                registroJuan
        );

        // Cargar datos de peso/altura en distintas fechas
        juan.cargarDatos(70.5, 172, LocalDate.of(2024, 3, 15));
        juan.cargarDatos(72.0, 173, LocalDate.of(2024, 8, 20));
        juan.cargarDatos(73.5, 175, LocalDate.of(2025, 1, 10));
        juan.cargarDatos(74.0, 176, LocalDate.of(2025, 6, 5));

        // Crear sistema y agregar la persona
        HashSet<Humano> personas = new HashSet<>();
        personas.add(juan);
        SistemaPesado sistema = new SistemaPesado(personas);

        // 1. Ver datos de una fecha
        System.out.println("=== Consulta por fecha ===");
        juan.verDatos(LocalDate.of(2024, 8, 20));

        // 2. Promedio de peso y altura en un año
        System.out.println("\n=== Promedio año 2024 ===");
        juan.promPerYear(2024);

        // 3. Porcentaje de crecimiento entre dos fechas
        System.out.println("\n=== Crecimiento entre marzo 2024 y junio 2025 ===");
        juan.entreFechas(
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2025, 6, 5)
        );
    }
}
