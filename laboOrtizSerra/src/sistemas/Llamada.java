package sistemas;

import personas.Empleado6;

import java.time.LocalDate;

public class Llamada {
    //al finalizar, se registra la duración. El sistema debe almacenar: empleado origen,
    // empleado destino, fecha y duración de cada llamada,
    private Empleado6 eOrigen;
    private Empleado6 eDestino;
    private LocalDate fecha;
    private float duracion;

    public Llamada(Empleado6 eOrigen, Empleado6 eDestino, LocalDate fecha, float duracion) {
        this.eOrigen = eOrigen;
        this.eDestino = eDestino;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public Empleado6 geteOrigen() {
        return eOrigen;
    }

    public void seteOrigen(Empleado6 eOrigen) {
        this.eOrigen = eOrigen;
    }

    public Empleado6 geteDestino() {
        return eDestino;
    }

    public void seteDestino(Empleado6 eDestino) {
        this.eDestino = eDestino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    public boolean esExtranjero(){
        return eOrigen.getPais().equals(eDestino.getPais());
    }
}
