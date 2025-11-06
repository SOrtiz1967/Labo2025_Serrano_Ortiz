package EntregaJava2da;

import java.net.InetSocketAddress;
import java.util.*;

public class RegistroClientes {
    private Map<String, ClienteRegistrado> clientesRegistrados = new HashMap<>();

    public static class ClienteRegistrado {
        String id;
        InetSocketAddress direccion;
        String tipo; // puedo hacer un enum capaz
        boolean activo;
        long timestampRegistro;

        public ClienteRegistrado(String id, InetSocketAddress direccion, String tipo) {
            this.id = id;
            this.direccion = direccion;
            this.tipo = tipo;
            this.activo = true;
            this.timestampRegistro = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return String.format("%s (%s) - %s [%s]",
                    id, tipo, direccion, activo ? "ACTIVO" : "INACTIVO");
        }
    }

    // registrar nuevo cliente
    public boolean registrarCliente(String id, InetSocketAddress direccion, String tipo) {
        if (clientesRegistrados.containsKey(id)) {
            // actualizar si ya existe
            ClienteRegistrado cliente = clientesRegistrados.get(id);
            cliente.direccion = direccion;
            cliente.activo = true;
            cliente.timestampRegistro = System.currentTimeMillis();
            System.out.println("Cliente actualizado: " + cliente);
            return true;
        }

        ClienteRegistrado nuevo = new ClienteRegistrado(id, direccion, tipo);
        clientesRegistrados.put(id, nuevo);
        System.out.println("Nuevo cliente registrado: " + nuevo);
        return true;
    }

    // obtener todos los clientes activos
    public List<InetSocketAddress> getClientesActivos() {
        List<InetSocketAddress> direcciones = new ArrayList<>();
        for (ClienteRegistrado cliente : clientesRegistrados.values()) {
            if (cliente.activo) {
                direcciones.add(cliente.direccion);
            }
        }
        return direcciones;
    }

    // obtener clientes por tipo
    public List<InetSocketAddress> getClientesPorTipo(String tipo) {
        List<InetSocketAddress> direcciones = new ArrayList<>();
        for (ClienteRegistrado cliente : clientesRegistrados.values()) {
            if (cliente.activo && cliente.tipo.equalsIgnoreCase(tipo)) {
                direcciones.add(cliente.direccion);
            }
        }
        return direcciones;
    }

    // marcar como inactivo
    public void marcarInactivo(InetSocketAddress direccion) {
        for (ClienteRegistrado cliente : clientesRegistrados.values()) {
            if (cliente.direccion.equals(direccion)) {
                cliente.activo = false;
                System.out.println("Cliente marcado como inactivo: " + cliente.id);
                break;
            }
        }
    }

    // ver todos los clientes
    public void mostrarClientes() {
        System.out.println("\n=== Clientes Registrados ===");
        if (clientesRegistrados.isEmpty()) {
            System.out.println("No hay clientes registrados todavia");
        } else {
            clientesRegistrados.values().forEach(c -> System.out.println("  - " + c));
        }

    }

    // esta resgistrado?
    public boolean estaRegistrado(String id) {
        return clientesRegistrados.containsKey(id);
    }

    // clientes activos
    public int cantidadActivos() {
        return (int) clientesRegistrados.values().stream()
                .filter(c -> c.activo)
                .count();
    }
}