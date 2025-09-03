package segundoCuatri.eleccionesOctubre;

import primerCuatri.probar.personas.Persona;

public class TelefonoMovil extends Dispositivo{
    //el teléfono móvil deberá guardar en
    // particular a qué compañía telefónica pertenece {Claro, Personal, Movistar o Tuenti} y el número
    // celular.
    private String compania;
    private int nTelefono;

    public TelefonoMovil(int nSerie, Persona fabricante, String modelo, String compania, int nTelefono) {
        super(nSerie, fabricante, modelo);
        this.compania = compania;
        this.nTelefono = nTelefono;
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
}
