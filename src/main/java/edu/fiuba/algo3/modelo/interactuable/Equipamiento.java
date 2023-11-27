package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;

public class Equipamiento implements Interactuable {

    @Override
    public void interactuarCon(Gladiador g) {
        g.actualizarEquipo();
    }
}
