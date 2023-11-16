package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Armadura implements Equipamiento {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(10);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new EscudoYEspada();
    }
}
