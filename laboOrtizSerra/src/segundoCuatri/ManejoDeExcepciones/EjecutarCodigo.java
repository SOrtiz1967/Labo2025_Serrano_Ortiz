package segundoCuatri.ManejoDeExcepciones;

public class EjecutarCodigo {
    //con throws
    public void mostrarTamanioNombre() throws NullPointerException {
        String nombre = null;
        System.out.println("El largo del nombre es:" + nombre.length());
    }

    public static void main(String[] args) {
            /*con try/catch
            try {
                String nombre = null;
                System.out.println("El largo del nombre es:" + nombre.length());
                } catch (NullPointerException e) {
                System.out.println("El valor del nombre es nulo");
            }
            System.out.println("Terminó la excepcion");*/
        //con throw
        try {
            String nombre = null;
            if (nombre.length()==0||nombre.isEmpty()) {
                throw new NullPointerException("El nombre está vacío");
        }} catch (NullPointerException e) {
            System.err.println(e);
        }
        //EjecutarCodigo e1= new EjecutarCodigo();
        //e1.mostrarTamanioNombre();
    }
}

