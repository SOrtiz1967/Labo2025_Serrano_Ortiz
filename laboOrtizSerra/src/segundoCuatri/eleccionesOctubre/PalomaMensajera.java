package segundoCuatri.eleccionesOctubre;

public class PalomaMensajera extends Ave{
    private boolean mapa;

    public boolean isMapa() {
        return mapa;
    }

    public void setMapa(boolean mapa) {
        this.mapa = mapa;
    }

    public PalomaMensajera(String color, String nombre, String especie, boolean mapa) {
        super(color, nombre, especie);
        this.mapa = mapa;
    }
}
