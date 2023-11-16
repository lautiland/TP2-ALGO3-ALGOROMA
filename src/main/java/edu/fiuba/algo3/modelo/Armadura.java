package edu.fiuba.algo3.modelo;

public class Armadura implements Equipamiento{
    @Override
    public int calcularEnergiaPerdida() {
        return 0;
    }

    @Override
    public Equipamiento mejorar() {
        return null;
    }
}
