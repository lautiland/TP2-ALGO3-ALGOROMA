package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Senior extends Nivel {

    @Override
    public Nivel actualizarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(10);
        return this;
    }
}
