package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class EscudoYEspada extends Equipo {

    @Override
    public void resistirAtaque(Gladiador g) {
        g.restarEnegia(2);
    }

    @Override
    public Equipo actualizar() {
        return new Llave();
    }

}
