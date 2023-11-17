package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Llave extends Equipamiento {
    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(0);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return this;
    }

}
