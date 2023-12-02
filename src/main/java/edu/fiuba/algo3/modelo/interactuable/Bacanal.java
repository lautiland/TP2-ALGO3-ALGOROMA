package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Bacanal implements Interactuable {

    public static final int PUNTOS_POR_TRAGO = 5;

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        System.out.println(", caiste en bacanal, tiras el dado nuevamente ");
        int tirada = gladiador.calcularMovimientos();
        System.out.print("Tiraste " + tirada + ", tomas " + tirada + " tragos, perdes " + PUNTOS_POR_TRAGO * tirada + " puntos ");
        gladiador.modificarEnergia(-PUNTOS_POR_TRAGO * tirada);
    }
}
