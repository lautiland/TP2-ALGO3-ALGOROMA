package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Casco implements Equipamiento {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(15);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Armadura();
    }


}
