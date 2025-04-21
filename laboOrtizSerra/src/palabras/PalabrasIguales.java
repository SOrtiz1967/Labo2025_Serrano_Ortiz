package palabras;
import java.util.Scanner;

public class PalabrasIguales {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int cantidad=0;
        System.out.println("Ingrese la primer palabra: ");
        String palabra1 = e.nextLine();
        System.out.println("Ingrese la segunda palabra: ");
        String palabra2= e.nextLine();
        for (int i = 0; i < palabra1.length(); i++) {
            for (int j = 0; j < palabra2.length(); j++) {
                if (palabra1.charAt(i)==palabra2.charAt(j)){
                    cantidad++;
                    break;
                }
            }
        }
        if (cantidad==palabra1.length()){
            System.out.println("son iguales");
        }
        else {
            System.out.println("son distintas");
        }
    }

}

