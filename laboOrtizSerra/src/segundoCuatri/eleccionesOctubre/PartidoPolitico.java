package segundoCuatri.eleccionesOctubre;

import java.util.HashSet;

public class PartidoPolitico {
    //Cada partido tiene un nombre, un dirección donde se encuentra la oficina central, una cantidad de afiliados
    // y una lista de los enviadores de mensajes.
    private String nombre;
    private String dieccionOficina;
    private int cAfiliados;
    private HashSet<AccionesCampaña> mensajeros;


    public PartidoPolitico(HashSet<AccionesCampaña> mensajeros) {
        this.nombre = "PeronCarajo";
        this.dieccionOficina = "alsina";
        this.cAfiliados = 91218;
        this.mensajeros = mensajeros;
    }
    

    public PartidoPolitico(String nombre, String dieccionOficina, int cAfiliados, HashSet<AccionesCampaña> mensajeros) {
        this.nombre = nombre;
        this.dieccionOficina = dieccionOficina;
        this.cAfiliados = cAfiliados;
        this.mensajeros = mensajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDieccionOficina() {
        return dieccionOficina;
    }

    public void setDieccionOficina(String dieccionOficina) {
        this.dieccionOficina = dieccionOficina;
    }

    public int getcAfiliados() {
        return cAfiliados;
    }

    public void setcAfiliados(int cAfiliados) {
        this.cAfiliados = cAfiliados;
    }

    public HashSet<AccionesCampaña> getMensajeros() {
        return mensajeros;
    }

    public void setMensajeros(HashSet<AccionesCampaña> mensajeros) {
        this.mensajeros = mensajeros;
    }
    public void agregarPanqueque(AccionesCampaña panqueque){
        mensajeros.add(panqueque);
    }
    public void hacerCampaña(){
        for (AccionesCampaña x: mensajeros){
            if(x.hacerCampaña()!=""){

                System.out.println(x.hacerCampaña() +" Vote por el partido para un mejor futuro");
            }
            else{
                System.out.println("este mensajero no esta disponible para hacer campaña");
            }

        }

    }
    public static void main(String[] args) {
        // Crear mensajeros
        PalomaMensajera paloma1 = new PalomaMensajera("Blanca", "Pichi", "elrita", true);
        PalomaMensajera paloma2 = new PalomaMensajera("Gris", "Nube", "Paloma", false);

        // TelefonoMovil (nota: falta la clase Persona, le pongo null por ahora)
        TelefonoMovil celular1 = new TelefonoMovil(1234, null, "Galaxy S21", "Claro", 11223344, 50.0, true);
        TelefonoMovil celular2 = new TelefonoMovil(5678, null, "iPhone 14", "Movistar", 22334455, 0.0, false);

        // Trabajador (con horario laboral)
        Trabajador trabajador1 = new Trabajador("Juan", 30, 20304050, 150000, "Av. Siempre Viva", 8, 18);
        Trabajador trabajador2 = new Trabajador("Ana", 28, 30405060, 120000, "Calle Falsa", 20, 23);

        // HashSet para mensajeros
        HashSet<AccionesCampaña> mensajeros = new HashSet<>();
        mensajeros.add(paloma1);
        mensajeros.add(paloma2);
        mensajeros.add(celular1);
        mensajeros.add(celular2);
        mensajeros.add(trabajador1);
        mensajeros.add(trabajador2);

        // Crear partido político
        PartidoPolitico partido = new PartidoPolitico("Unidos por el Futuro", "Calle Libertad 123", 1000, mensajeros);

        // Hacer campaña
        System.out.println("=== INICIANDO CAMPAÑA ===");
        partido.hacerCampaña();
    }
}
