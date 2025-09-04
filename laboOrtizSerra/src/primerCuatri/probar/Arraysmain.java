package primerCuatri.probar;

import primerCuatri.probar.personas.Persona;

import java.util.ArrayList;

public class Arraysmain {
    public static void main(String[] args) {
        // Ejercicio 1
        /*
        a. Crear un ArrayList de números enteros y mostrar su suma.
        b. Crear un ArrayList de primerCuatri.probar.palabras y mostrar solo los elementos que empiezan con una letra específica.
        c. Crear un ArrayList de primerCuatri.probar.objetos Persona y mostrar solo las primerCuatri.probar.personas que tienen más de 30 años.
         */
        // A
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(7);
        numeros.add(82);
        numeros.add(35);
        numeros.add(95);
        numeros.add(526);
        int suma=0;
        for (Integer numero : numeros){
            suma+=numero;
        }
        System.out.println("la suma de todos los numros es: "+suma);
        //B
        ArrayList<String> palabras = new ArrayList<String>();
        palabras.add("auriculares");
        palabras.add("musica");
        palabras.add("botella");
        palabras.add("guitarra");
        palabras.add("mouse");
        palabras.add("cable");
        palabras.add("teclado");
        for (String palabra : palabras){
            if(palabra.charAt(0)=='a'){
                System.out.println(palabra);
            }
        }
        //C
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Matias Faya", 17));
        personas.add(new Persona("Ariadna Leyes", 21));
        personas.add(new Persona("Martina Cardillo", 20));
        personas.add(new Persona("Geronimo Benavidez", 38));
        personas.add(new Persona("Benjamín Gael", 17));
        for (Persona persona : personas){
            //seria muy util tener un metodo en la clase persona al que pasandole un valor
            //numerico(edad)
            //nos devuelva true si es mayor
            //creé ese metodo para la resolucion de ese ejercicio
            if(persona.esMayor(30)){
                System.out.println(persona.getNombre());
            }

        }






    }
}
