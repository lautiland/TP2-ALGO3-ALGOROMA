package edu.fiuba.algo3.modelo.premio;

import edu.fiuba.algo3.modelo.Gladiador;

public class Comida implements Premio {

    @Override
    public void aplicarEfecto(Gladiador g) {
        g.comer();
    }
}
