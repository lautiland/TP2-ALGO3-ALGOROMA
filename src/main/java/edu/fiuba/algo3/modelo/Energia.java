package edu.fiuba.algo3.modelo;

public class Energia {

    private int cantidadPuntos = 0;

    public void sumarPuntos(int cantidad) {
        this.cantidadPuntos += cantidad;
    }

    public void restarPuntos(int cantidad) {
        this.cantidadPuntos = cantidad;
    }
}
