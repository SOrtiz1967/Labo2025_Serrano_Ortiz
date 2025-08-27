package segundoCuatri.EJRepaso2;

import java.time.LocalDate;
import java.util.HashMap;

public class Profesor extends Participantes{
    private double sueldo;
    private TipoProfesor tipoProfesor;
    private HashMap<String,LocalDate> bancoYFecha;
    private LocalDate fechaAlta;
    private HashMap<String,Integer> materiaConHorasDictadas;
}
