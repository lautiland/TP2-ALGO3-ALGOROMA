package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.nivel.Nivel;

public class Energia {

    private int puntos = 20;

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    public void restarPuntos(int cantidad) {
        this.puntos -= cantidad;
    }

    public boolean tenes(int puntos) {
        return this.puntos == puntos;
    }
}
