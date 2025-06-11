package Tecnologia;

import objetos.Componente;

public class CPU extends Componente {
    public CPU() {
        super("INTEL", "C57", 1500, 15);
    }

    public CPU(String fabricante, String modelo, double precio, int stock) {
        super(fabricante, modelo, precio, stock);
    }
}
