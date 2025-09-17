package segundoCuatri.arcoyflecha;

import primerCuatri.probar.objetos.Plato;

import java.util.HashSet;

public class BeneficioComida extends Beneficio implements Acumulable{
    // Si es un beneficio de comidas, se almacenan también una lista
    // de las comidas
    private HashSet<Plato> comidas;

    public BeneficioComida(String nombe, String creador, HashSet<Plato> comidas) {
        super(nombe, creador);
        this.comidas = comidas;
    }

    public HashSet<Plato> getComidas() {
        return comidas;
    }

    public void setComidas(HashSet<Plato> comidas) {
        this.comidas = comidas;
    }

    @Override
    public int aplicarDescuentoExtra() {
        return 4500;
    }
}
