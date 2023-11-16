package edu.fiuba.algo3.modelo;

public class Tablero {

    public void avanzar(Gladiador gladiador, Dado dado){
        int cantidadDeCasilleros = dado.tirar();
        Posicion posicionActual = gladiador.obtenerPosicion();
        Posicion nuevaPosicion = new Posicion(posicionActual.obtenerX() + cantidadDeCasilleros, posicionActual.obtenerY());
        gladiador.mover(nuevaPosicion);
    }
}
