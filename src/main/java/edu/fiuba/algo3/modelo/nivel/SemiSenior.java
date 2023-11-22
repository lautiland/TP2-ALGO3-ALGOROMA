package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class SemiSenior extends Nivel {

    @Override
    public Nivel actualizarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(5);
        if (turnosJugados == 9)
            return new Senior();

        return this;
    }
}
