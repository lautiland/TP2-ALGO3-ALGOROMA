package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Gladiador;

public class Novato extends Nivel {

    @Override
    public Nivel actualizarPuntos(Gladiador g, int turnosJugados) {
        g.sumarEnergia(0);
        if (turnosJugados == 8)
            return new SemiSenior();

        return this;

    }

}
