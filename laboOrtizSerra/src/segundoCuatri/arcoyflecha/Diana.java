package segundoCuatri.arcoyflecha;

import java.util.HashMap;

public abstract class Diana {
    //  Las Dianas se dividen en tres tipos: Circulares, rectangulares y cuadradas. Todas las dianas
    // tendrán un nombre identificatorio, un nivel de dificultad y una lista que relaciona el puntaje
    // en cada franja con el color (los colores pueden ser sólo rojo, verde, amarillo, blanco o negro).
    // Tener en cuenta que los puntajes no se repiten en una misma diana. Además de eso, a todas las
    // dianas circulares se les agrega el valor del radio que es de 13cm, a las dianas rectangulares se
    // les agrega el valor de la altura y la base y a las dianas cuadradas se pide guardar el valor del lado.
    private String nombre;
    private String nivel;
    private HashMap<Integer,Color> puntaje;

    public Diana(String nombre, String nivel, HashMap<Integer, Color> puntaje) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntaje = puntaje;
    }


    public Diana() {
        this.nombre = "pepon";
        this.nivel = "bronce";
        this.puntaje = new HashMap<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public HashMap<Integer, Color> getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(HashMap<Integer, Color> puntaje) {
        this.puntaje = puntaje;
    }
    public abstract double calcularArea();
}
