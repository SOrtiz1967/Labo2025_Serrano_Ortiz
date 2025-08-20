package segundoCuatri.ManejoDeExcepciones;

public class EjecutarCodigo {
    //con throws
    public void mostrarTamanioNombre() throws Personalizada {
        String nombre = null;
        if(nombre==null){
            throw new Personalizada("nombre vacio");
        }
        System.out.println("El largo del nombre es:" + nombre.length());
    }

    public static void main(String[] args) throws Personalizada{
            /*con try/catch
            try {
                String nombre = null;
                System.out.println("El largo del nombre es:" + nombre.length());
                } catch (NullPointerException e) {
                System.out.println("El valor del nombre es nulo");
            }
            System.out.println("Terminó la excepcion");*/
        //con throw
        /*try {
            String nombre = null;
            if (nombre==null) {
                throw new NullPointerException("El nombre está vacío");
        }} catch (NullPointerException e) {
            System.err.println(e);
        }*/
        EjecutarCodigo e1= new EjecutarCodigo();
        e1.mostrarTamanioNombre();

    }
}

