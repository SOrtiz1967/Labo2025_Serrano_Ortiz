package Tecnologia;

import java.time.LocalDate;

public abstract class Dispositivo {

    protected boolean estado;
    protected double medida;
    protected float umbralInicial;
    protected LocalDate añoAdquisicion;

    public Dispositivo(boolean estado, float medida, float umbralInicial, LocalDate añoAdquisicion) {
        this.estado = estado;
        this.medida = medida;
        this.umbralInicial = umbralInicial;
        this.añoAdquisicion = añoAdquisicion;
    }

    public void tomarMedida() {
        if (estado) {
            if (debeActivarAlarma()) {
                Alarma();
            }
        }
    }
    public boolean debeActivarAlarma(){
        return medida>umbralInicial;
    }
    public abstract void Alarma();

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getUmbralInicial() {
        return umbralInicial;
    }

    public void setUmbralInicial(float umbralInicial) {
        this.umbralInicial = umbralInicial;
    }

    public LocalDate getAñoAdquisicion() {
        return añoAdquisicion;
    }

    public void setAñoAdquisicion(LocalDate añoAdquisicion) {
        this.añoAdquisicion = añoAdquisicion;
    }
}
