package U0;
import java.util.Vector;
import java.util.Scanner;

public class IntroducirNumeros {
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
    }
}
