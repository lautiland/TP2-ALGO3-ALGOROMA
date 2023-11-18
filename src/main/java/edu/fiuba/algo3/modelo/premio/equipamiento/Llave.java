package edu.fiuba.algo3.modelo.premio.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Llave extends Equipo {
    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(0);
    }

    @Override
    public Equipo actualizar() {
        return this;
    }

}
