package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class EscudoYEspada extends Equipamiento {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(2);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Llave();
    }

}
