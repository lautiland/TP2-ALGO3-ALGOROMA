package edu.fiuba.algo3.model.interactuable;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.tablero.Camino;

public class SinInteraccion implements Interactuable {
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
    }

    @Override
    public String toString() {
        return "sininteraccion";
    }
}
