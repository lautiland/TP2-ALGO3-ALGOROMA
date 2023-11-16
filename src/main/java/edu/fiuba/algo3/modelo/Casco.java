package edu.fiuba.algo3.modelo;

public class Casco implements Equipamiento{

    @Override
    public int calcularEnergiaPerdida() {
        return 5;
    }

    @Override
    public Equipamiento mejorar() {
        return new Armadura();
    }
}
