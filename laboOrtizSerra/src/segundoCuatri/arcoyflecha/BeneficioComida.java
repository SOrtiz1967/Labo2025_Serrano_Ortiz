package segundoCuatri.arcoyflecha;

import java.util.HashSet;

public class BeneficioComida extends Beneficio implements Acumulable{
    // Si es un beneficio de comidas, se almacenan también una lista
    // de las comidas
    private HashSet<String> comidas;

    public BeneficioComida(String nombe, String creador, HashSet<String> comidas) {
        super(nombe, creador);
        this.comidas = comidas;
    }

    public HashSet<String> getComidas() {
        return comidas;
    }

    public void setComidas(HashSet<String> comidas) {
        this.comidas = comidas;
    }

    @Override
    public int aplicarDescuentoExtra() {
        return 4500;
    }
}
