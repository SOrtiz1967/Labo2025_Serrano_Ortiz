package segundoCuatri.arcoyflecha;

import java.util.HashSet;

public class BeneficioGaseosa extends Beneficio implements Acumulable{
    //Si es un beneficio de gaseosa, se almacenan
    //también a una lista de las gaseosas
    private HashSet<String> gaseosas;

    public BeneficioGaseosa(String nombe, String creador, HashSet<String> gaseosas) {
        super(nombe, creador);
        this.gaseosas = gaseosas;
    }

    public HashSet<String> getGaseosas() {
        return gaseosas;
    }

    public void setGaseosas(HashSet<String> gaseosas) {
        this.gaseosas = gaseosas;
    }

    @Override
    public int aplicarDescuentoExtra() {
        return 1000;
    }
}
