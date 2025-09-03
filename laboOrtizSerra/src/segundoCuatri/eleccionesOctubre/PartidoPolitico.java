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
}
