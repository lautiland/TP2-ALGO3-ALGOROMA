package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Gladiador;

public interface Estado {

    Estado jugar(Gladiador gladiador);

    default Estado jugar(Gladiador gladiador, Camino camino) {
        return jugar(gladiador);
    }
}
