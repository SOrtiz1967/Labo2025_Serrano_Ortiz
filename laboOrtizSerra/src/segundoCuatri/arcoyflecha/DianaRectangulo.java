package segundoCuatri.arcoyflecha;

import java.util.HashMap;

public class DianaRectangulo extends Diana{
    // las dianas rectangulares se les agrega el valor de la altura y la base
    private double base;
    private double altura;

    public DianaRectangulo(String nombre, String nivel, HashMap<Integer, Color> puntaje, double base, double altura) {
        super(nombre, nivel, puntaje);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base*altura;
    }
}
