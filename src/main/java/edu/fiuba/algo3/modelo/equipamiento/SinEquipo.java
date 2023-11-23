package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class SinEquipo extends Equipo {

    @Override
    public void resistirAtaque(Gladiador g) {
        g.restarEnegia(20);
    }

    @Override
    public Equipo actualizar() {
        return new Casco();
    }
}
