package segundoCuatri.EjerciciosComplejidad;

import java.util.ArrayList;
import java.util.Collections;

public class EJ11 {

    public static int masFrecuente(ArrayList<Integer> lista) {
        int M = lista.size();

        // 1️⃣ Creamos el ArrayList de conteo y lo inicializamos manualmente con ceros
        ArrayList<Integer> conteo = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            conteo.add(0);
        }

        // 2️⃣ Contamos cuántas veces aparece cada número
        for (int num : lista) {
            conteo.set(num, conteo.get(num) + 1);
        }

        // 3️⃣ Buscamos el número con mayor frecuencia
        int maxFrecuencia = 0;
        int numeroMasFrecuente = -1;

        for (int i = 0; i <= M; i++) {
            if (conteo.get(i) > maxFrecuencia) {
                maxFrecuencia = conteo.get(i);
                numeroMasFrecuente = i;
            }
        }

        return numeroMasFrecuente;
    }

    // Método main para probar
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(0);
        numeros.add(3);
        numeros.add(1);

        int resultado = masFrecuente(numeros);
        System.out.println("El número más frecuente es: " + resultado);
    }
}