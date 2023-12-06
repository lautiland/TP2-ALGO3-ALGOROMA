package edu.fiuba.algo3.model.interactuable;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public class Lesion implements Interactuable {
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " se lesiono");
        gladiador.lesionar();
    }
}
