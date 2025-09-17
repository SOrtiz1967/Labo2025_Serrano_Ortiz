package segundoCuatri.arcoyflecha;

import java.util.HashMap;

public class DianaCircular extends Diana{
    //  Además de eso, a todas las
    //  dianas circulares se les agrega el valor del radio que es de 13cm,
    private static int radio=13;

    public DianaCircular(String nombre, String nivel, HashMap<Integer, Color> puntaje) {
        super(nombre, nivel, puntaje);
    }


    @Override
    public double calcularArea() {
        return Math.PI*radio*radio;
    }

    public static int getRadio() {
        return radio;
    }

    public static void setRadio(int radio) {
        DianaCircular.radio = radio;
    }
}
