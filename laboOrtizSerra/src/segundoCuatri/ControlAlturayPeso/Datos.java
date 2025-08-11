package segundoCuatri.ControlAlturayPeso;

public class Datos {
    private double peso;//kg
    private int altura;//cm

    public Datos(double peso, int altura) {
        this.peso = peso;
        this.altura = altura;
    }
    public Datos() {
        this.peso = 83.0;
        this.altura = 170;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
