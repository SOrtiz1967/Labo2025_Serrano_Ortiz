package Vacunatorio;

import java.time.LocalDate;

public class Vacuna {
    /*as vacunas tienen una fecha de fabricación,
     fecha d eaplicación, numero de lote, numero de fabricacion y nombre comercial.*/
    private LocalDate fFabricacion;
    private LocalDate fAplicacion;
    private int nLote;
    private int nFabricacion;
    private String nombreComercial;

    public Vacuna(LocalDate fFabricacion, LocalDate fAplicacion, int nLote, int nFabricacion, String nombreComercial) {
        this.fFabricacion = fFabricacion;
        this.fAplicacion = fAplicacion;
        this.nLote = nLote;
        this.nFabricacion = nFabricacion;
        this.nombreComercial = nombreComercial;
    }

    public LocalDate getfFabricacion() {
        return fFabricacion;
    }

    public void setfFabricacion(LocalDate fFabricacion) {
        this.fFabricacion = fFabricacion;
    }

    public LocalDate getfAplicacion() {
        return fAplicacion;
    }

    public void setfAplicacion(LocalDate fAplicacion) {
        this.fAplicacion = fAplicacion;
    }

    public int getnLote() {
        return nLote;
    }

    public void setnLote(int nLote) {
        this.nLote = nLote;
    }

    public int getnFabricacion() {
        return nFabricacion;
    }

    public void setnFabricacion(int nFabricacion) {
        this.nFabricacion = nFabricacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
}
