package edu.fiuba.algo3.model.interactuable;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.tablero.Camino;

public class Equipamiento implements Interactuable {

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        gladiador.actualizarEquipamiento();
    }

    @Override
    public String toString() {
        return "equipamiento";
    }
}
