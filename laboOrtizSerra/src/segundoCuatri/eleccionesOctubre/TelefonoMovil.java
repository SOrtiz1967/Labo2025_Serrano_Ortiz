package segundoCuatri.eleccionesOctubre;

import primerCuatri.probar.personas.Persona;

public class TelefonoMovil extends Dispositivo implements AccionesCampaña{
    //el teléfono móvil deberá guardar en
    // particular a qué compañía telefónica pertenece {Claro, Personal, Movistar o Tuenti} y el número
    // celular.
    private String compania;
    private int nTelefono;
    private double credito;
    private boolean on_off;

    public TelefonoMovil(int nSerie, Persona fabricante, String modelo, String compania, int nTelefono, double credito, boolean on_off) {
        super(nSerie, fabricante, modelo);
        this.compania = compania;
        this.nTelefono = nTelefono;
        this.credito = credito;
        this.on_off = on_off;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public int getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(int nTelefono) {
        this.nTelefono = nTelefono;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public boolean isOn_off() {
        return on_off;
    }

    public void setOn_off(boolean on_off) {
        this.on_off = on_off;
    }

    @Override
    public String hacerCampaña() {
        if (credito>0 && on_off){
            return "Conectando con la antena más cercana";
        }
        return "";
    }
}
