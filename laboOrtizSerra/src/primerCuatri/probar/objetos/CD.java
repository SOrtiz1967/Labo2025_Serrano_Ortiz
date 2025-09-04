package primerCuatri.probar.objetos;

import java.util.ArrayList;



public class CD {
    private String nombre;
    private ArrayList<Cancion> canciones;
    //constructor default
    public CD(){
        this.nombre="DTMF";
        this.canciones=new ArrayList<Cancion>();
        canciones.add(new Cancion("NUEVAYoL","BD"));
        canciones.add(new Cancion("BOkETE","BD"));
        canciones.add(new Cancion("WELTITA","BD"));
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int numeroCanciones(){
        int tamanio=canciones.size();
        return tamanio;
    }
    public Cancion verCancion(int posicion){

        return canciones.get(posicion);
    }
    public void grabaCancion(int posicion, Cancion nuevaCancion){
        // Reemplaza la canción en esa posición por una nueva.
        //uso el .set
        canciones.set(posicion, nuevaCancion);
    }
    public void agrega(Cancion cancion){
        canciones.add(cancion);
    }
    public void elimina(int posicion){
        canciones.remove(posicion);
    }

    public static void main(String[] args) {
        CD cd1= new CD();
        System.out.println("en el cd tenes: "+cd1.numeroCanciones()+" canciones" +" la cancion en la posicion 1 es: " + cd1.verCancion(1).getTitulo());
        //grabar, agregar y eliminar
        System.out.print("este es el cd que tenes: ");
        for (Cancion cancion: cd1.getCanciones() ){
            System.out.print(cancion.getTitulo() + " ");
        }
        System.out.println("");
        //graba
        cd1.grabaCancion(0, new Cancion("BAiLE INOLVIDABLE", "BD"));
        System.out.print("este es el cd despues de grabar: ");
        for (Cancion cancion: cd1.getCanciones() ){
            System.out.print(cancion.getTitulo() + " ");
        }
        System.out.println("");
        //agrega
        cd1.agrega(new Cancion("ameri", "duki"));
        //elimina
        cd1.elimina(2);
        System.out.println("este es el cd despues de agregar una cancion y borrar la 2: ");
        for (Cancion cancion: cd1.getCanciones() ){
            System.out.print(cancion.getTitulo() + " ");
        }

    }
}
