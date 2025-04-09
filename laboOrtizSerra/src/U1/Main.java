package U1;

public class Main {
    public static void main(String[] args) {
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
        System.out.println("el color del auto es: " + co1.getColor() + "La marca: " + co1.getMarca() + );
        System.out.println("la base es: "+ r1.getBase()+" la altura es: " + r1.getAltura());
        System.out.println("el radio del circulo es: "+ c1.getRadio());
        double areaR = r1.area();
        double perimetroR = r1.perimetro();
        double areaC = c1.area();
        double perimetroC= c1.perimetro();
        System.out.println("area da: " + areaR+ " perimetro da: " + perimetroR);
        System.out.println(" area del circulo da: "+ areaC+ " perimetro del circulo da: "+ perimetroC);
    }
}
