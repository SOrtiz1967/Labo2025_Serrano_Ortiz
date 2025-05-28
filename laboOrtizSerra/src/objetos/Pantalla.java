package objetos;

import java.util.ArrayList;

public class Pantalla extends Salida{
    private int fps;
    public Pantalla(String fabricante, String modelo, double precio, int stock, ArrayList<String> puertos, int fps) {
        super(fabricante, modelo, precio, stock, puertos);
        this.fps=fps;
    }
    public int getFps() {
        return fps;
    }
    public void setFps(int fps) {
        this.fps = fps;
    }
}
