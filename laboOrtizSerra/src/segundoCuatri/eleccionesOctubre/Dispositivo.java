package segundoCuatri.eleccionesOctubre;

import primerCuatri.probar.personas.Persona;

public class Dispositivo {
    // los teléfonos móviles pertenecen al grupo de dispositivos por lo que, si bien es común para
    // todo dispositivo el número de serie, fabricante y modelo, el teléfono móvil deberá guardar en
    // particular a qué compañía telefónica pertenece {Claro, Personal, Movistar o Tuenti} y el número
    // celular.
    private int nSerie;
    private Persona fabricante;
    private String modelo;

    public Dispositivo(int nSerie, Persona fabricante, String modelo) {
        this.nSerie = nSerie;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    public Persona getFabricante() {
        return fabricante;
    }

    public void setFabricante(Persona fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
