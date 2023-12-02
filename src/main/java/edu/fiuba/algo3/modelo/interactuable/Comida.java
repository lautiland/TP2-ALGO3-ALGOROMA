package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Comida implements Interactuable {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 10;

    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        System.out.print(", encontraste moretum, ganas " + PUNTOS_DE_ENERGIA_GANADOS + " puntos");
        gladiador.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
    }
}
