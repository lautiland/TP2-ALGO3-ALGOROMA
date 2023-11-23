package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Nivel {

    public abstract Nivel actualizarPuntos(Gladiador g, int turnosJugados);


    public boolean equals(Nivel n) {
        return this.getClass() == n.getClass();
    }

}
