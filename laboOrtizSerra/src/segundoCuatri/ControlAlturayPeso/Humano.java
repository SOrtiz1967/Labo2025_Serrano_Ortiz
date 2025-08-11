package segundoCuatri.ControlAlturayPeso;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Humano {//no lo extiendo de persona por que tiene edad y aca necesito la fecha de nacimiento.
    private String nombre;
    private String apellido;
    private LocalDate fNacimiento;
    private HashMap<Datos, LocalDate> registro; //peso y altura con la fecha al ritmo|_//Al revés está mejor <LocalDate,Datos>

    public void promPerYear(int año){// speramos un ingreso como2025
        HashSet<Datos> registrosAnio= new HashSet<>();
        for (Map.Entry<Datos, LocalDate> valor : registro.entrySet()){
            if (valor.getValue().getYear()==año){
                //meter los datos en el hashset
                registrosAnio.add(valor.getKey());
            }
        }
        int altura=0;
        double peso=0;
        for (Datos d5: registrosAnio){
            altura+=d5.getAltura();
            peso+=d5.getPeso();
        }
        System.out.println("el promedio de altura en el año "+año+ " es: "+ altura/registrosAnio.size()+" y el peso promedio es "+ peso/registrosAnio.size());
    }
    public void verDatos(LocalDate f){
        if(registro.containsValue(f)){
            for (Map.Entry<Datos, LocalDate> valor : registro.entrySet()){
                if (valor.getValue().equals(f)){
                    System.out.println("en esa fecha peso: " + valor.getKey().getPeso()+ "y midio: "+ valor.getKey().getAltura());
                }
            }
        }
        else{
            System.out.println("error con la fecha, no hay registros en esa fecha");
        }

    }
    public void entreFechas(LocalDate f1, LocalDate f2){

        if(registro.containsValue(f1) || registro.containsValue(f2)){
            int a1=0,a2 = 0;
            for (Map.Entry<Datos, LocalDate> valor : registro.entrySet()) {
                if (valor.getValue().equals(f1)) {
                    a1 = valor.getKey().getAltura();
                }
                if (valor.getValue().equals(f2)) {
                    a2 = valor.getKey().getAltura();
                }
            }
            System.out.println("el porcentaje de crecimiento entre esas fechas es: "+ ((a2 - a1) / a1) * 100);
        }
        else{
            System.out.println("algo anda mal con esas fechas :(");
        }
    }
    public Humano(String nombre, String apellido, LocalDate fNacimiento, HashMap<Datos, LocalDate> registro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fNacimiento = fNacimiento;
        this.registro = registro;
    }
    public void cargarDatos(double peso, int altura, LocalDate fecha){//si quiere que sea hoy que ponga la current date
        Datos d1=new Datos(peso,altura);
        registro.put(d1, fecha);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public HashMap<Datos, LocalDate> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Datos, LocalDate> registro) {
        this.registro = registro;
    }
}
