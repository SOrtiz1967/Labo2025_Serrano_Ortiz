package tests;
/*
import objetos.Plato;
import personas.Alumno;
import personas.Profesor;
import personas.Persona;
import Pedidos.Pedido;
import sistemas.SistemaPedidoAlmuerzos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaPedidoAlmuerzosTest {
    private SistemaPedidoAlmuerzos sistema;
    private Plato milanesa, ensalada, sopa;
    private Profesor profe;
    private Alumno alu;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaPedidoAlmuerzos();

        milanesa = new Plato("Milanesa", 1500);
        ensalada = new Plato("Ensalada", 1200);
        sopa = new Plato("Sopa", 1000);

        sistema.agregar_p(milanesa);
        sistema.agregar_p(ensalada);
        sistema.agregar_p(sopa);

        profe = new Profesor("Ana", 45, "Pérez", "Dirección", 20);
        alu = new Alumno("Luis", "Gómez", LocalDate.of(2007, 6, 2), new ArrayList<>());

        sistema.getProfesores().add(profe);
        sistema.getAlumnos().add(alu);

        // Pedidos para popular estadísticas
        agregarPedido(milanesa, profe, true, LocalDate.now());
        agregarPedido(milanesa, alu, true, LocalDate.now());
        agregarPedido(milanesa, alu, true, LocalDate.now().minusDays(1));

        agregarPedido(ensalada, alu, true, LocalDate.now());
        agregarPedido(sopa, alu, true, LocalDate.now());
    }

    private void agregarPedido(Plato plato, Persona solicitante, boolean entregado, LocalDate fecha) {
        ArrayList<Plato> lista = new ArrayList<>();
        lista.add(plato);
        Pedido pedido = new Pedido(fecha, lista, solicitante, LocalTime.now(), entregado);
        sistema.getPedidos().add(pedido);
    }

    @Test
    public void testPlatosACocinarEnElDia() {
        ArrayList<Plato> platosHoy = sistema.platosACocinarEnElDia();
        assertEquals(4, platosHoy.size());

        for (Plato p : platosHoy) {
            if (p.getNombre().equals("Milanesa") && p.getPrecio() < 1500) {
                assertEquals(1200.0, p.getPrecio(), 0.01); // 20% de descuento
            }
        }
    }

    @Test
    public void testTop3() {
        ArrayList<Plato> top3 = sistema.top3();

        assertEquals(3, top3.size());
        assertEquals("Milanesa", top3.get(0).getNombre());
        assertEquals("Ensalada", top3.get(1).getNombre());
        assertEquals("Sopa", top3.get(2).getNombre());
    }

    @Test
    public void testDescuentoProfesor() {
        ArrayList<Plato> platosHoy = sistema.platosACocinarEnElDia();

        double precioEsperado = 1500 * 0.8;
        for (Plato p : platosHoy) {
            if (p.getNombre().equals("Milanesa") && p.getPrecio() < 1500) {
                assertEquals(precioEsperado, p.getPrecio(), 0.01);
            }
        }
    }
}
*/