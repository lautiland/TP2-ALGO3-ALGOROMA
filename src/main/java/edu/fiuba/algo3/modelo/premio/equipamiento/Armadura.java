package edu.fiuba.algo3.modelo.premio.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Armadura extends Equipo {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(10);
    }

    @Override
    public Equipo actualizar() {
        return new EscudoYEspada();
    }
}