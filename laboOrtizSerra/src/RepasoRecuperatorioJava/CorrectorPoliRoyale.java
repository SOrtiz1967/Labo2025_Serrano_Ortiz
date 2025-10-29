package RepasoRecuperatorioJava;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.Normalizer;

public class CorrectorPoliRoyale {

    private static String normalizar(String s) {
        if (s == null) return "";
        return Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    private static boolean contieneAlguno(String texto, String... patrones) {
        for (String p : patrones) {
            if (texto.contains(p.toLowerCase())) return true;
        }
        return false;
    }

    private static boolean contieneTodos(String texto, String... patrones) {
        for (String p : patrones) {
            if (!texto.contains(p.toLowerCase())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        try {
            PoliRoyaleApp.main(new String[]{});
        } catch (Throwable t) {
            System.out.flush();
            System.setOut(old);
            System.out.println("❌ Error al ejecutar PoliRoyaleApp.main(): " +
                    t.getClass().getSimpleName() + " - " + t.getMessage());
            return;
        }

        System.out.flush();
        System.setOut(old);

        String salida = normalizar(baos.toString());

        System.out.println("=== Salida del alumno (normalizada) ===");
        System.out.println(salida + "\n");

        int puntos = 0;
        int total = 10;

        boolean cartaComun = contieneAlguno(salida, "Soy una carta común y mi costo de elixir es:", "Soy una carta comun y mi costo de elixir es:");
        boolean cartaEspecial = contieneAlguno(salida, "Soy una carta especial de nivel", "y mi costo de elixir actual es:");
        boolean cartaEpica = contieneAlguno(salida, "Soy una carta épica, me jugaron y me desbloqueo en:", "Soy una carta epica, me jugaron y me desbloqueo en:");

        if (cartaComun && cartaEspecial && cartaEpica) {
            System.out.println("✅ Conocer frases icónicas detectadas para las tres cartas");
            puntos += 2;
        } else {
            System.out.println("❌ No se detectaron correctamente las frases icónicas de las cartas");
        }

        boolean elixirOk = contieneAlguno(salida, "Elixir suficiente para que esta carta sea usada");
        boolean exElixir = contieneAlguno(salida, "No hay elixir suficiente");

        if (elixirOk) {
            System.out.println("✅ Caso elixir suficiente detectado");
            puntos++;
        } else {
            System.out.println("❌ No se detectó mensaje de elixir suficiente");
        }

        if (exElixir) {
            System.out.println("✅ Excepción por falta de elixir detectado");
            puntos++;
        } else {
            System.out.println("❌ No se detectó excepción por falta de elixir");
        }

        boolean descComun = contieneAlguno(salida, "Soy una carta común pero no por eso soy débil!", "Soy una carta comun pero no por eso soy debil!");
        boolean descEspecial = contieneAlguno(salida, "Soy una carta especial y puedo contra todo!");

        if (descComun && descEspecial) {
            System.out.println("✅ Descripciones de cartas detectadas");
            puntos++;
        } else {
            System.out.println("❌ Faltan descripciones de cartas");
        }

        boolean cartaFavorita = contieneAlguno(salida, "Carta favorita registrada con éxito", "Carta favorita registrada con exito");

        if (cartaFavorita) {
            System.out.println("✅ Carta favorita cargada con éxito detectada");
            puntos++;
        } else {
            System.out.println("❌ No se detectó mensaje de carta favorita cargada");
        }

        boolean cartaOk = contieneAlguno(salida, "Se ha agregado correctamente la carta");
        boolean exValores = contieneAlguno(salida, "Carta con valores inválidos", "Carta con valores invalidos");

        if (cartaOk) {
            System.out.println("✅ Nueva carta agregada correctamente");
            puntos++;
        } else {
            System.out.println("❌ No se detectó mensaje de nueva carta exitosa");
        }

        if (exValores) {
            System.out.println("✅ Excepción por carta con valores inválidos detectada");
            puntos++;
        } else {
            System.out.println("❌ No se detectó excepción por carta con valores inválidos");
        }

        boolean subirLvl = contieneAlguno(salida, "La carta ha sido reforzada correctamente, mi nueva vida es:");
        if (subirLvl) {
            System.out.println("✅ Subir nivel de carta detectada");
            puntos++;
        } else {
            System.out.println("❌ No se detectó subir nivel de carta");
        }

        boolean cantJugables = contieneAlguno(salida, "La cantidad de cartas actualmente jugables son:",
                "La cantidad de cartas jugables son:", "Las cartas jugables son:", "Cartas jugables:");
        if (cantJugables) {
            System.out.println("✅ Conteo de cartas jugables detectado");
            puntos++;
        } else {
            System.out.println("❌ No se detectó conteo de cartas jugables");
        }

        System.out.println("\nPuntaje final Poli Royale: " + puntos + "/" + total);
    }
}

