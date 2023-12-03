package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Bacanal implements Interactuable {

    public static final int PUNTOS_POR_TRAGO = 5;

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("Gladiador " + gladiador.getNombre() + " cayó en una Bacanal");
        int tirada = gladiador.calcularMovimientos();
        Logger.getInstance().info("Tiraste " + tirada + ", tomas " + tirada + " tragos, perdes " + PUNTOS_POR_TRAGO * tirada + " puntos ");
        gladiador.modificarEnergia(-PUNTOS_POR_TRAGO * tirada);
    }
}
