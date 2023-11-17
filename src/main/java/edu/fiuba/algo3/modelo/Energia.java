package edu.fiuba.algo3.modelo;

public class Energia {

    private int puntos = 20;

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    public void restarPuntos(int cantidad) {
        this.puntos -= cantidad;
    }

    public int getPuntos() {
        return this.puntos;
    }
}
