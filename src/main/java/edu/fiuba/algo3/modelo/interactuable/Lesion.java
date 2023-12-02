package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Lesion implements Interactuable {
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        System.out.print(", te lesionaste");
        gladiador.lesionar();
    }
}
