package personas;
import java.util.Random;
public class Empleado6 extends User{
    private int dni;
    private String pais;
    // metodo para hacer llamad ingresando el numero de tlefono
    public static int generarMinutosRandom() {
        Random random = new Random();
        return random.nextInt(121);
    }
    public void llamar(int telefono){
        //la duracion me la invento yo!
        int duracion=generarMinutosRandom();
        //registramos la llamada
        


    }
    public Empleado6(String nombre, String apellido, int telefono, int dni, String pais) {
        super(nombre, apellido, telefono);
        this.dni = dni;
        this.pais = pais;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
