package segundoCuatri.arcoyflecha;

import java.util.HashSet;

public class BeneficioTrago extends Beneficio{
    private HashSet<String> tragos;

    public BeneficioTrago(String nombe, String creador, HashSet<String> tragos) {
        super(nombe, creador);
        this.tragos = tragos;
    }

    public HashSet<String> getTragos() {
        return tragos;
    }

    public void setTragos(HashSet<String> tragos) {
        this.tragos = tragos;
    }
}
