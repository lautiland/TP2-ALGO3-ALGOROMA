package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;

public class Comida implements Interactuable {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 10;

    @Override
    public void interactuarCon(Gladiador g) {
        System.out.print(", encontraste pizza, ganas " + PUNTOS_DE_ENERGIA_GANADOS + " puntos");
        g.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
    }
}
