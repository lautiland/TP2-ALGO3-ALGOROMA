package edu.fiuba.algo3.premio.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Casco extends Equipo {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(15);
    }

    @Override
    public Equipo actualizar() {
        return new Armadura();
    }
}
