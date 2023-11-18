package edu.fiuba.algo3.modelo;

public class Casilla {

    private final Efecto efecto;

    public Casilla(Efecto e) {
        this.efecto = e;
    }

    public void aplicarEfecto(Gladiador g) {
        this.efecto.aplicar(g);
    }
}
