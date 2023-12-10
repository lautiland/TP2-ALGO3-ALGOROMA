package edu.fiuba.algo3.model.interactuable;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public class Llegada implements Interactuable {
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " llegó a la meta");
        if (gladiador.abrirPuerta(camino)) {
            camino.reclamarPremio(gladiador);
        }
    }

    @Override
    public String toString() {
        return "Llegada";
    }
}