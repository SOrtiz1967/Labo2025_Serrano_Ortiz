package U0;

public class Vocales {
    public static void main(String[] args) {
        String vocale="aeiouAEIOUáéíóú";
        String frase="Ayer me compré muñecos de la marca ‘ToyCo’ por internet.";
        int cantidad=0;
        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < vocale.length(); j++) {
                if(frase.charAt(i)==vocale.charAt(j)){
                    cantidad++;
                }
            }
        }
        System.out.println(cantidad);
    }
}
