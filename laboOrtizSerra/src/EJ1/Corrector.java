package EJ1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.Normalizer;

    public class Corrector {

        private static String norm(String s) {
            if (s == null) return "";
            String n = Normalizer.normalize(s, Normalizer.Form.NFD)
                    .replaceAll("\\p{M}", "");
            return n.toLowerCase();
        }

        private static boolean containsAll(String haystack, String... needles) {
            for (String n : needles) {
                if (!haystack.contains(n.toLowerCase())) return false;
            }
            return true;
        }

        private static boolean containsAny(String haystack, String... needles) {
            for (String n : needles) {
                if (haystack.contains(n.toLowerCase())) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);

            try {
                BibliotecaApp.main(new String[]{});
            } catch (Throwable t) {
                System.out.flush();
                System.setOut(old);
                System.out.println("❌ Error ejecutando BibliotecaApp.main(): " + t.getClass().getSimpleName() + " - " + t.getMessage());
                return;
            }

            System.out.flush();
            System.setOut(old);

            String salida = baos.toString();
            String S = norm(salida);

            System.out.println("=== Salida del alumno (normalizada) ===");
            System.out.println(S + "\n");

            int puntos = 0;
            int total = 10;

            boolean busqOk = (containsAll(S, "titulo", "autor", "ano") || containsAll(S, "título", "autor", "año"))
                    || containsAll(S, "titulo", "autor");
            if (busqOk) { puntos++; System.out.println("✅ Busqueda muestra titulo/autor/ano"); }
            else System.out.println("❌ Busqueda incompleta (no se ve titulo/autor/ano)");

            boolean sugierePrestamo = containsAny(S, "si quiere tomelo prestado", "si quiere tomalo prestado", "prestarlo");
            if (sugierePrestamo) { puntos++; System.out.println("✅ Sugerencia de prestamo cuando es prestable"); }
            else System.out.println("❌ No se detecto sugerencia de prestamo para prestables");

            boolean noExiste = containsAny(S, "no tenemos el libro", "no tenemos ese libro", "no existe");
            if (noExiste) { puntos++; System.out.println("✅ Caso busqueda no existe (mensaje correcto)"); }
            else System.out.println("❌ No se detecto mensaje de inexistencia en busqueda");

            boolean disponibleOk = containsAny(S, "esta disponible para ser prestado", "esta disponible para prestamo");
            if (disponibleOk) { puntos++; System.out.println("✅ Verificacion de disponibilidad OK"); }
            else System.out.println("❌ No se detecto verificacion positiva de disponibilidad");

            boolean fallaPrestar = containsAny(S, "no se puede dar a prestamo", "no se puede dar en prestamo");
            boolean fallaStock = containsAny(S, "no hay stock suficiente", "sin stock", "stock insuficiente");
            if (fallaPrestar || fallaStock) { puntos++; System.out.println("✅ Excepciones de disponibilidad detectadas"); }
            else System.out.println("❌ No se detectaron excepciones de disponibilidad");

            boolean prestamoOk = containsAny(S, "prestamo agregado", "se agrego el prestamo", "prestamo creado");
            if (prestamoOk) { puntos++; System.out.println("✅ Prestamo agregado OK"); }
            else System.out.println("❌ No se detecto confirmacion de prestamo agregado");

            boolean fechaLibro = containsAny(S, "libro") && containsAny(S, "+15", "15 dias", "15 dias");
            boolean fechaRevista10 = containsAny(S, "revista") && containsAny(S, "10 dias", "+10");
            boolean fechaRevista3 = containsAny(S, "revista") && containsAny(S, "3 dias", "+3");
            if (fechaLibro || fechaRevista10 || fechaRevista3) { puntos++; System.out.println("✅ Regla de fechas de devolucion detectada"); }
            else System.out.println("❌ No se detectaron evidencias de fechas de devolucion");

            boolean devolFueraFecha = containsAny(S, "prestamo devuelto fuera de fecha");
            if (devolFueraFecha) { puntos++; System.out.println("✅ Excepcion por devolucion fuera de fecha detectada"); }
            else System.out.println("❌ No se detecto excepcion por devolucion fuera de fecha");

            boolean multaLibro = containsAny(S, "multa") && containsAny(S, "libro") && containsAny(S, "7500");
            boolean multaRevista = containsAny(S, "multa") && containsAny(S, "revista") && containsAny(S, "3500");
            if (multaLibro || multaRevista) { puntos++; System.out.println("✅ Multa detectada (libro o revista)"); }
            else System.out.println("❌ No se detecto evidencia de multa");

            boolean extendOk = containsAny(S, "prestamo extendido");
            boolean extendFail = containsAny(S, "no es posible extender el prestamo", "no es posible extender");
            if (extendOk || extendFail) { puntos++; System.out.println("✅ Logica de extension (exito o rechazo) detectada"); }
            else System.out.println("❌ No se detecto evidencia de extension de prestamo");

            System.out.println("\nPuntaje final Prestamos: " + puntos + "/" + total);
        }
    }
}
