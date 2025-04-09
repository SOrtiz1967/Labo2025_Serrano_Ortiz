package U1;

public class Main {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo();
        Circulo c1= new Circulo();
        c1.setRadio(4);
        r1.setBase(8);
        r1.setAltura(4);
        System.out.println("la base es: "+ r1.getBase()+" la altura es: " + r1.getAltura());
        System.out.println("el radio del circulo es: "+ c1.getRadio());
        double areaR = r1.area(r1.getBase(), r1.getAltura());
        double perimetroR = r1.perimetro(r1.getBase(), r1.getAltura());
        double areaC = c1.area(c1.getRadio());
        double perimetroC= c1.perimetro(c1.getRadio());
        System.out.println("area da: " + areaR+ " perimetro da: " + perimetroR);
        System.out.println(" area del circulo da: "+ areaC+ " perimetro del circulo da: "+ perimetroC);
    }
}
