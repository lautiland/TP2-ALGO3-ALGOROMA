package edu.fiuba.algo3.modelo;

public class Energia {
    private int puntos;
    // Podria implementar Puntuable
    public Energia(int puntosIniciales){
        puntos = puntosIniciales;
    }

    public void sumarPuntos(int puntosASumar){
        puntos += puntosASumar;
    }

    public void restarPuntos(int puntosARestar){
        puntos -= puntosARestar;
    }

    public int obtenerPuntos(){
        return puntos;
    }
}
