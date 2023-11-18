package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class EscudoYEspada extends Equipo {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(2);
    }

    @Override
    public Equipo actualizar() {
        return new Llave();
    }

}
