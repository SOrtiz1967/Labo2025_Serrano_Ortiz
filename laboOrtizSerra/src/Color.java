public enum Color {
    ROJO("#fa0000"), AZUL("000bfa"), AMARILLO("faef00"), VERDE("faef00"), NEGRO("#000000"), BLANCO("#ffffff"), ROSA("#ff80e2");
    private String codigo;

    Color(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
