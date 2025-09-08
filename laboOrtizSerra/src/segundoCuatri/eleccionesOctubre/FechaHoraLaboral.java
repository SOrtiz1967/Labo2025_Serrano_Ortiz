package segundoCuatri.eleccionesOctubre;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class FechaHoraLaboral {

    public static boolean obtenerFechaHoraYLaboral(int horaInicio, int horaFin) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Rango laboral según parámetros
        LocalTime inicio = LocalTime.of(horaInicio, 0);
        LocalTime fin = LocalTime.of(horaFin, 0);

        // Verificar día y hora
        boolean esDiaLaboral = ahora.getDayOfWeek() != DayOfWeek.SATURDAY &&
                ahora.getDayOfWeek() != DayOfWeek.SUNDAY;
        boolean esHoraLaboral = !ahora.toLocalTime().isBefore(inicio) &&
                !ahora.toLocalTime().isAfter(fin);

        String mensaje = "Fecha y hora: " + ahora.format(formato);

        if (esDiaLaboral && esHoraLaboral) {
            mensaje += " ✅ Está en horario laboral.";
            return true;
        } else {
            mensaje += " ❌ No está en horario laboral.";
            return false;
        }

        //return mensaje;
    }


}
