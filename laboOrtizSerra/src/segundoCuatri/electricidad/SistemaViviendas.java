package segundoCuatri.electricidad;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class SistemaViviendas {
    private HashSet<Vivienda> viviendas;

    public SistemaViviendas(HashSet<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }

    public HashSet<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(HashSet<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }
    public void cargarConsumosMes() {
        Scanner sc = new Scanner(System.in);
        LocalDate hoy = LocalDate.now();

        for (Vivienda v : viviendas) {
            System.out.println("Ingrese consumo en KWh para la vivienda en: " + v.getDireccion());
            int consumo = sc.nextInt();

            v.cargarConsumo(hoy, consumo);
        }
    }
}
