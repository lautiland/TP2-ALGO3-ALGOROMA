package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        Posicion posicion = (Posicion) o;
        return x == posicion.obtenerX() && y == posicion.obtenerY();
    }
}
