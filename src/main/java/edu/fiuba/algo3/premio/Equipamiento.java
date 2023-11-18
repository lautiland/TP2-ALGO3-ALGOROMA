package edu.fiuba.algo3.premio;

import edu.fiuba.algo3.modelo.Gladiador;

public class Equipamiento implements Premio {

    @Override
    public void aplicarEfecto(Gladiador g) {
        g.actualizarEquipo();
    }
}
