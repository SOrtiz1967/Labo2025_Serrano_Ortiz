package figuras;

public class Rectangulo {
    private int Base;
    private int Altura;
    //constructor por defecto
    public Rectangulo(int Base, int Altura){
        this.Base=3;
        this.Altura=6;
    }

    //constructor parametrizado
    public Rectangulo(){
        this.Base=Base;
        this.Altura=Altura;

    }
    public int getBase(){
        return Base;
    }
    public int getAltura(){
        return Altura;
    }
    public void setBase(int Base){
        this.Base = Base;
    }
    public void setAltura(int Altura){
        this.Altura = Altura;
    }
    public double area(){
        double area0= Base*Altura;
        return area0;
    }
    public double perimetro(){
        double perimetro0= Base*2+Altura*2;
        return perimetro0;
    }
}
