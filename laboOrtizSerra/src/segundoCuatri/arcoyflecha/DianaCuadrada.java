package segundoCuatri.arcoyflecha;

import java.util.HashMap;

public class DianaCuadrada extends Diana{
    private int lado;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public DianaCuadrada(String nombre, String nivel, HashMap<Integer, Color> puntaje, int lado) {
        super(nombre, nivel, puntaje);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado*lado;
    }
}
