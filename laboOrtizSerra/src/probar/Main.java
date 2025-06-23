package probar;

import fecha.Fecha;
import figuras.Circulo;
import figuras.Rectangulo;
import objetos.Cancion;
import objetos.Editorial;
import objetos.Libro;
import personas.Persona;
import vehiculo.Cafetera;
import vehiculo.Coche;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Rectangulo r1 = new Rectangulo();
        Circulo c1= new Circulo();
        Coche co1= new Coche();
        co1.setColor("Amarillo");
        co1.setMarca("Nissan");
        co1.setVelocidad(40);
        co1.setModelo("frontier");
        c1.setRadio(4);
        r1.setBase(8);
        r1.setAltura(4);
        System.out.println("el color del auto es: " + co1.getColor() + "La marca: " + co1.getMarca() + "El modelo es: " + co1.getModelo()+ "La velocidad es: " + co1.getVelocidad());
        System.out.println("la base es: "+ r1.getBase()+" la altura es: " + r1.getAltura());
        System.out.println("el radio del circulo es: "+ c1.getRadio());
        double areaR = r1.area();
        double perimetroR = r1.perimetro();
        double areaC = c1.area();
        double perimetroC= c1.perimetro();
        co1.acelerar();
        co1.frenar();
        co1.mostrarVelocidadActual();
        System.out.println("area da: " + areaR+ " perimetro da: " + perimetroR);
        System.out.println(" area del circulo da: "+ areaC+ " perimetro del circulo da: "+ perimetroC);
        System.out.println();
        //ejercicio persona
        //Persona p1 = new Persona();
        p1.imprimirDatos();
        // ejercicio fecha
        Fecha f1= new Fecha();
        Fecha f2= new Fecha();
        f1.anterior();
        f1.larga();
        f1.siguiente();
        f1.valida();
        f1.corta();
        System.out.println(f1.mayorQue(f2));
        System.out.println(f1.diasMes());
        System.out.println(f1.igualQue(f2));
        System.out.println(f1.igualQue(f2));
        //ejercicio libro
        Libro l1= new Libro();
        l1.getAutor();
        l1.getEditorial();
        l1.getISBN();
        l1.getFechaPublicacion();
        l1.getPaginas();
        l1.getTitulo();
        l1.setAutor(p1);
        l1.setFechaPublicacion(f2);
        l1.setISBN(45);
        l1.setPaginas(250);
        l1.setEditorial(Editorial.SUDAMERICANA);
        l1.setTitulo("Las increibles aventuras de Fran");
        l1.mayorQue(f1);
        l1.mostrarDatos();
        //ejercicio cafetera
        Cafetera caf1= new Cafetera();
        caf1.setCantidadActual(300);
        caf1.setCantidadMaxima(1000);
        caf1.llenarCafetera();
        caf1.servirTaza(200);
        caf1.vaciarCafetera();
        caf1.agregarCafe(500);
        System.out.println("cantidad actual: " + caf1.getCantidadActual() + "cantidad maxima: " + caf1.getCantidadMaxima());
        //ejercicio cancion
        Cancion can1= new Cancion();
        can1.setAutor("El nehu");
        can1.setTitulo("Mi yo");
        System.out.println("Autor: " + can1.getAutor() + " Titulo: " + can1.getTitulo());

        // Ejercicio 1
        /*
        a. Crear un ArrayList de números enteros y mostrar su suma.
        b. Crear un ArrayList de palabras y mostrar solo los elementos que empiezan con una letra específica.
        c. Crear un ArrayList de objetos Persona y mostrar solo las personas que tienen más de 30 años.

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

         */
    }
}
