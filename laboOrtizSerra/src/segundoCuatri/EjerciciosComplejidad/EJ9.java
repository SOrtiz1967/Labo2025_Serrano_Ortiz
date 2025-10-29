package segundoCuatri.EjerciciosComplejidad;

public class EJ9 {
        public static int[] indicesComunes(int[] v1, int[] v2, int[] v3) {
            int i = 0, j = 0, k = 0;

            while (i < v1.length && j < v2.length && k < v3.length) {
                if (v1[i] == v2[j] && v2[j] == v3[k]) {
                    return new int[]{i, j, k};
                }

                int min = Math.min(v1[i], Math.min(v2[j], v3[k]));
                if (v1[i] == min) i++;
                else if (v2[j] == min) j++;
                else k++;
            }

            return null; // en teoría no pasa porque el enunciado dice que sí hay un elemento común
        }

        public static void main(String[] args) {
            int[] v1 = {1, 3, 4};
            int[] v2 = {3, 5, 7};
            int[] v3 = {1, 2, 3};

            int[] indices = indicesComunes(v1, v2, v3);
            if (indices != null) {
                System.out.println("Índices comunes: [" + indices[0] + ", " + indices[1] + ", " + indices[2] + "]");
            }
        }
}
