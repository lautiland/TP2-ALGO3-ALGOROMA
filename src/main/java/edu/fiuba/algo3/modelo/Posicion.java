package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {
    private int actual;
    public Posicion(int inicial){
        this.actual = inicial;
    }

    public int obtenerActual() {
        return actual;
    }

    public void avanzar(int cantidadDeCasilleros){
        actual += cantidadDeCasilleros;
    }

    @Override
    public boolean equals(Object o) {
        Posicion posicion = (Posicion) o;
        return actual == posicion.obtenerActual();
    }
}
