package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Armadura extends Equipo {

    @Override
    public void resistirAtaque(Gladiador g) {
        g.restarEnegia(10);
    }

    @Override
    public Equipo actualizar() {
        return new EscudoYEspada();
    }
}
