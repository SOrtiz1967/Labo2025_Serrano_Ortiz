package segundoCuatri.eleccionesOctubre;

public class PalomaMensajera extends Ave implements AccionesCampaña{
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

    @Override
    public String hacerCampaña() {
        if(mapa){
            return "Lanzando un papelito que dice:";
        }
        return "";
    }
}
