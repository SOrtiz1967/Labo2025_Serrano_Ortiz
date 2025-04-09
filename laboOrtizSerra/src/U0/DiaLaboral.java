package U0;

import java.util.Scanner;

public class DiaLaboral {

    public static void main(String[] args) {
        /*Crear un programa que nos pida un día de la semana y nos diga si es un día
        laboral o no. Los días laborales se consideran de lunes a viernes.
         */
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingresa el dia de la semana");
        String dia = entrada.nextLine();
        if (dia.equals("sabado") || dia.equals("domingo")){
            System.out.println("es fin de semana:)");
        }
        else {
            System.out.println("es un dia laboral:(");
        }
    }
}
