package U1;

public class Circulo {
    private int radio;
    public Circulo(){
        this.radio=2;
    }
    public Circulo(int radio){
        this.radio=radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    public double area(){
        double pi=Math.PI;
        double areaa=pi*(radio^2);
        return areaa;
    }
    public double perimetro(){
        double pi= Math.PI;
        double perimetroo=pi*radio*2;
        return perimetroo;
    }
}
