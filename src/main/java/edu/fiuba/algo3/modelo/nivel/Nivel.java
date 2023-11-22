package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.equipamiento.Equipo;

public abstract class Nivel {

    public abstract Nivel actualizarPuntos(Energia e, int turnosJugados);


    public boolean equals(Nivel n) {
        return this.getClass() == n.getClass();
    }

}
