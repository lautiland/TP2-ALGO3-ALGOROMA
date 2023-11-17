package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Llave implements Equipamiento {
    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(0);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return this;
    }

}
