package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehiculo.*;
import Estados.EstadoDron;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class testDron {


    private Delivery delivery;
    private Vigilante vigilante;

    @BeforeEach
    public void setUp() {
        delivery = new Delivery();
        delivery.setnModelo("salastraidor");
        delivery.setfAdqisicion(LocalDate.now());
        delivery.setEstado(EstadoDron.ENVUELO);
        delivery.setBateria(60);

        vigilante = new Vigilante();
        vigilante.setnModelo("salasvigilante");
        vigilante.setfAdqisicion(LocalDate.now());
        vigilante.setEstado(EstadoDron.ENVUELO);
        vigilante.setBateria(80);
        vigilante.setMemoriaSD(0); // comienza vacía
        vigilante.setAlmacenamientoMaximo(120); // puede almacenar hasta 10 fotos (cada 2 km)
    }

    @Test
    public void testCargarBateriaNormal() {
        delivery.setBateria(80);
        delivery.cargarBateria();
        assertEquals(90, delivery.getBateria());
    }

    @Test
    public void testCargarBateriaCritica() {
        delivery.setBateria(10);
        delivery.cargarBateria();
        assertEquals(100, delivery.getBateria());
    }

    @Test
    public void testDeliveryPuedeRealizarMisionExitosa() {
        double lat = -34.58, lon = -58.50; // ~1 km de distancia
        assertTrue(delivery.realizarMision(lon, lat));
        assertEquals(10, delivery.getBateria()); // 60 - 50
    }

    @Test
    public void testDeliveryFallaPorBateria() {
        delivery.setBateria(40);
        double lat = -34.58, lon = -58.50;
        assertFalse(delivery.realizarMision(lon, lat));
    }

    @Test
    public void testVigilantePuedeRealizarMisionExitosa() {
        double lat = -34.68, lon = -58.50; // ~12 km (6 fotos -> 72 MB)
        boolean resultado = vigilante.realizarMision(lon, lat);
        assertTrue(resultado);
        assertTrue(vigilante.getMemoriaSD() > 0);
    }

    @Test
    public void testVigilanteFallaPorMemoria() {
        vigilante.setAlmacenamientoMaximo(20); // muy poca capacidad
        double lat = -34.68, lon = -58.50;
        assertFalse(vigilante.realizarMision(lon, lat));
    }

}
