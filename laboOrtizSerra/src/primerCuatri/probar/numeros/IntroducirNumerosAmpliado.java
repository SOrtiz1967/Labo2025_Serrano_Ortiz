package primerCuatri.probar.numeros;

import java.util.Scanner;
import java.util.Vector;

public class IntroducirNumerosAmpliado {
    public static void main(String[] args) {
        Vector<Integer> numeros = new Vector<>();
        Scanner n = new Scanner(System.in);
        boolean condicion = true;

        while (condicion) {
            System.out.println("Ingrese números, cuando desee parar ingrese -1:");
            int numero = n.nextInt();

            if (numero != -1) {
                numeros.add(numero);
            } else {
                condicion = false;
            }
        }

        // Mostrar los números ingresados
        System.out.println("Números ingresados: " + numeros);

        // Hallar el mayor, menor y la suma
        int nMayor = numeros.elementAt(0);
        int nMenor = numeros.elementAt(0);
        int suma = 0;
        int sumaPos = 0;
        int sumaNega= 0;

        for (int i = 0; i < numeros.size(); i++) {
            int actual = numeros.elementAt(i);
            if (nMayor < actual) {
                nMayor = actual;
            }
            if (nMenor > actual) {
                nMenor = actual;
            }
            suma += actual;
            if (numeros.elementAt(i)<0){
                sumaNega += numeros.elementAt(i);
            }
            if (numeros.elementAt(i)>0){
                sumaPos += numeros.elementAt(i);
            }
        }

        System.out.println("Número mayor: " + nMayor);
        System.out.println("Número menor: " + nMenor);
        System.out.println("Suma total: " + suma);
        System.out.println("suma de primerCuatri.probar.numeros positivos: " + sumaPos);
        System.out.println("suma de primerCuatri.probar.numeros negativos: " + sumaNega);
    }
}
