package edu.fiuba.algo3.modelo;

public class Energia {

    private int cantidadPuntos = 20;

    public void sumarPuntos(int cantidad) {
        this.cantidadPuntos += cantidad;
    }

    public void restarPuntos(int cantidad) {
        this.cantidadPuntos -= cantidad;
    }

    public int getPuntos() {
        return this.cantidadPuntos;
    }
}
