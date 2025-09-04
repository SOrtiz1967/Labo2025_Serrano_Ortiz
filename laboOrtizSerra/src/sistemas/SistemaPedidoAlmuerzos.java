package sistemas;

import primerCuatri.probar.Pedidos.Pedido;
import primerCuatri.probar.objetos.Plato;
import primerCuatri.probar.personas.Alumno;
import primerCuatri.probar.personas.Profesor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaPedidoAlmuerzos {
    private ArrayList<Plato>platos;
    private ArrayList<Pedido>pedidos;
    private ArrayList<Profesor>profesores;
    private ArrayList<Alumno>alumnos;

    public SistemaPedidoAlmuerzos(ArrayList<Plato> platos, ArrayList<Pedido> pedidos,ArrayList<Profesor>profes, ArrayList<Alumno> alumnos) {
        this.platos = platos;
        this.pedidos = pedidos;
        this.profesores=profes;
        this.alumnos=alumnos;
    }

    public SistemaPedidoAlmuerzos() {
        this.platos=new ArrayList<Plato>();
        this.pedidos=new ArrayList<Pedido>();
        this.profesores=new ArrayList<Profesor>();
        this.alumnos= new ArrayList<Alumno>();
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregar_p (Plato pl){
        this.platos.add(pl);
    }
    public void eliminar_p(Plato pl){
        this.platos.remove(pl);
    }
    public void modificar_p(Plato pl,Plato platoARemover){
        this.agregar_p(pl);
        this.eliminar_p(platoARemover);
    }
    public ArrayList<Plato> platosACocinarEnElDia() {
        ArrayList<Plato> platosacocinar = new ArrayList<>();

        for (Pedido pedido : this.pedidos) {
            if (pedido.getF_c().equals(LocalDate.now()) && pedido.isEntregado()) {
                for (Plato original : pedido.getPlato()) {
                    Plato platoacocinar = new Plato(original.getNombre(), original.getPrecio());

                    if (pedido.getSolicitante() instanceof Profesor) {
                        Profesor profe = (Profesor) pedido.getSolicitante();
                        double precioConDescuento = platoacocinar.getPrecio() * (100 - profe.getPorcentaje_descuento()) / 100.0;
                        platoacocinar.setPrecio(precioConDescuento);
                    }

                    platosacocinar.add(platoacocinar);
                }
            }
        }

        return platosacocinar;
    }


    public int cantidaddevecespedidas(Plato plato){
        int cantidad_de_veces_pedidas = 0;
        for(Pedido pedido : this.pedidos){
            for(Plato p : pedido.getPlato()){
                if(p.getNombre().equals(plato.getNombre())) {
                    cantidad_de_veces_pedidas++;
                }
            }
        }
        return cantidad_de_veces_pedidas;
    }


    public ArrayList<Plato> top3() {
        ArrayList<Plato> copiaPlatos = new ArrayList<>(this.platos);

        copiaPlatos.sort((p1, p2) -> {
            int cantidad1 = cantidaddevecespedidas(p1);
            int cantidad2 = cantidaddevecespedidas(p2);
            return Integer.compare(cantidad2, cantidad1);
        });

        ArrayList<Plato> top3 = new ArrayList<>();
        for (int i = 0; i < Math.min(3, copiaPlatos.size()); i++) {
            top3.add(copiaPlatos.get(i));
        }

        return top3;
    }
        public static void main(String[] args) {
            SistemaPedidoAlmuerzos sistema = new SistemaPedidoAlmuerzos();

            Plato milanesa = new Plato("Milanesa con papas", 1500);
            Plato ensalada = new Plato("Ensalada César", 1200);

            sistema.agregar_p(milanesa);
            sistema.agregar_p(ensalada);

            Profesor profe = new Profesor("Ana", 45, "Pérez", "Rosario de la frontera 4913", 10); // 10% de descuento
            sistema.getProfesores().add(profe);

            Alumno alu = new Alumno("Luis", "Gómez", LocalDate.of(2007, 6, 2), new ArrayList<Double>());
            sistema.getAlumnos().add(alu);

            ArrayList<Plato> lista1 = new ArrayList<>();
            lista1.add(milanesa);
            Pedido pedido1 = new Pedido(LocalDate.now(), lista1, profe, LocalTime.now(), true);

            ArrayList<Plato> lista2 = new ArrayList<>();
            lista2.add(ensalada);
            Pedido pedido2 = new Pedido(LocalDate.now(), lista2, alu, LocalTime.now(), true);

            ArrayList<Plato> lista3 = new ArrayList<>();
            lista3.add(milanesa);
            Pedido pedido3 = new Pedido(LocalDate.now().minusDays(1), lista3, alu, LocalTime.now().minusHours(1), true);

            sistema.getPedidos().add(pedido1);
            sistema.getPedidos().add(pedido2);
            sistema.getPedidos().add(pedido3);

            System.out.println("Platos a cocinar hoy:");
            for (Plato p : sistema.platosACocinarEnElDia()) {
                System.out.println("- " + p.getNombre() + " $" + p.getPrecio());
            }
        }
}

