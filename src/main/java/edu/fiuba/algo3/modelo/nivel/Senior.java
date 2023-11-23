package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Gladiador;

public class Senior extends Nivel {

    @Override
    public Nivel actualizarPuntos(Gladiador g, int turnosJugados) {
        g.sumarEnergia(10);
        return this;
    }
}
