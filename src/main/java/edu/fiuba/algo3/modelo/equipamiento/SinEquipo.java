package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class SinEquipo extends Equipamiento {
    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(20);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Casco();
    }
}
