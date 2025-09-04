package primerCuatri.probar.objetos;
public class Tarjeta extends MetodoPago{
    private String numero;
    private String vencimiento;
    private String codigoSeguridad;
    public Tarjeta(String numero, String vencimiento, String codigoSeguridad) {
        this.numero = numero;
        this.vencimiento = vencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }
    public double calcularMonto(double monto){
        return monto * 1.05;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getVencimiento() {
        return vencimiento;
    }
    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
