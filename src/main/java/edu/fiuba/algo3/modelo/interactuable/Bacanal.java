package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;

public class Bacanal implements Interactuable {

    public static final int PUNTOS_POR_TRAGO = 5;
    
    @Override
    public void interactuarCon(Gladiador g) {
        System.out.println(", caiste en bacanal, tiras el dado nuevamente ");
        int tirada = Dado.tirar();
        System.out.print("Tiraste "+ tirada + ", tomas " + tirada + " tragos, perdes " + PUNTOS_POR_TRAGO*tirada + " puntos ");
        g.modificarEnergia(-PUNTOS_POR_TRAGO*tirada);
    }
}
