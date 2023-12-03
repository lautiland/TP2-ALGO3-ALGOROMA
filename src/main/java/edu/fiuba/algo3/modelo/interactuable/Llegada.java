package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Llegada implements Interactuable {
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " llegó a la meta");
        if (gladiador.abrirPuerta(camino)) {
            camino.reclamarPremio(gladiador);
        }
    }
}