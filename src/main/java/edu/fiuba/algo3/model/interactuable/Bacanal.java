package edu.fiuba.algo3.model.interactuable;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public class Bacanal implements Interactuable {

    public static final int PUNTOS_POR_TRAGO = 5;

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("Gladiador " + gladiador.getNombre() + " cayó en una Bacanal");
        int tirada = gladiador.calcularMovimientos();
        Logger.getInstance().info("Tiraste " + tirada + ", tomas " + tirada + " tragos, perdes " + PUNTOS_POR_TRAGO * tirada + " puntos ");
        gladiador.modificarEnergia(-PUNTOS_POR_TRAGO * tirada);
    }

    @Override
    public String toString() {
        return "Bacanal";
    }
}
