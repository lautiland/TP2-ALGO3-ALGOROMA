package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public interface Interactuable {

    void interactuarCon(Gladiador gladiador, Camino camino);
}
