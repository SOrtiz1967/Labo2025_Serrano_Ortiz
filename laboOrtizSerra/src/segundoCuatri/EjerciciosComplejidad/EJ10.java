package segundoCuatri.EjerciciosComplejidad;

public class EJ10 {
    public static int[] ordenar123(int[] v) {
        int[] conteo = new int[3]; // conteo[0] = cantidad de 1s, [1] = de 2s, [2] = de 3s

        for (int num : v) {
            conteo[num - 1]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < conteo[i]; j++) {
                v[index++] = i + 1;
            }
        }
        return v;
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 1, 1, 3, 3};
        int[] ordenado = ordenar123(v);

        System.out.print("Vector ordenado: [");
        for (int i = 0; i < ordenado.length; i++) {
            System.out.print(ordenado[i]);
            if (i < ordenado.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

}
