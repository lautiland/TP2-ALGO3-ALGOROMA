package edu.fiuba.algo3.modelo;

public class NivelFactory {

    public Nivel obtenerInstancia(String nivel) {
        if (nivel.contentEquals("NOVATO")) {
            return new Novato();
        }

        return new Novato();
    }

}
