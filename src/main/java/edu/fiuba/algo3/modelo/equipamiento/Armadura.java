package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Armadura extends Equipamiento {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(10);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new EscudoYEspada();
    }
}
