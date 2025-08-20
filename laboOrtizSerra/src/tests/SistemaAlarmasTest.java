package tests;/*
import ejercicioAlarmas.Dispositivo;
import objetos.*;
import ejercicioAlarmas.SistemaAlarmas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaAlarmasTest {
    private DetectorHumo detector;
    private SensorTemperatura temperatura;
    private SensorPresion presion;
    private SensorCompuesto compuesto;
    private SistemaAlarmas sistema;

    @BeforeEach
    public void setUp() {
        detector = new DetectorHumo(true, 90, 50, LocalDate.now());
        temperatura = new SensorTemperatura(true, 75, 70, LocalDate.now());
        presion = new SensorPresion(true, 80, 85, LocalDate.now());

        ArrayList<Dispositivo> lista = new ArrayList<>();
        lista.add(detector);
        lista.add(temperatura);
        lista.add(presion);
        compuesto = new SensorCompuesto(true, 0, 60, LocalDate.now(), lista);

        ArrayList<Dispositivo> todos = new ArrayList<>();
        todos.add(detector);
        todos.add(temperatura);
        todos.add(presion);
        todos.add(compuesto);

        sistema = new SistemaAlarmas(todos);
    }

    @Test
    public void testDebeActivarAlarmaDetector() {
        assertTrue(detector.debeActivarAlarma());
    }

    @Test
    public void testNoActivaAlarmaPresion() {
        assertFalse(presion.debeActivarAlarma());
    }

    @Test
    public void testActivarAlarmaCompuesto() {
        assertTrue(compuesto.debeActivarAlarma());
    }

    @Test
    public void testChequearSistema() {
        sistema.chequear(); // Verifica que no arroje errores (puede observarse en consola)
    }
}

*/