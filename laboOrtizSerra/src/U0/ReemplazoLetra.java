package U0;

import java.util.Scanner;

public class ReemplazoLetra {
    public static void main(String[] args) {
        /*
        Reemplazar todas las ‘e’ del ejercicio anterior
        por la letra que ingrese el usuario.
         */
        Scanner entrada = new Scanner(System.in);
        System.out.println("por que letra queres reemplazar");
        String inpu= entrada.nextLine();
        char reemplazo = inpu.charAt(0);
        String frase="Ayer me compré muñecos de la marca ‘ToyCo’ por internet.";
        String nueva=frase.replace('e', reemplazo);
        System.out.println("la frase con la e reemplazada es: "+ nueva);
        /*
        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i)=='e'){
                frase.charAt(i) = reemplazo;
            }
        }
         */

    }
}
