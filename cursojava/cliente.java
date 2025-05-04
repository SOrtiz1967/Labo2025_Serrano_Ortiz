package personas;

public class Cliente {

    private String nombreCompleto;

    public Cliente() {
        this.nombreCompleto = "Carlos";
    }

    public Cliente(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public static void main(String[] args) {
        // main vacíio
    }
}
