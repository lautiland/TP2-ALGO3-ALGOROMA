package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Equipamiento implements Interactuable {

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        gladiador.actualizarEquipo();
    }
}
