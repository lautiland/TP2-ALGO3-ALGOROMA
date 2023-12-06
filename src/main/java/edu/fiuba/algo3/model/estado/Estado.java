package edu.fiuba.algo3.model.estado;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.tablero.Camino;

public interface Estado {

    Estado jugar(Gladiador gladiador);

    default Estado jugar(Gladiador gladiador, Camino camino) {
        return jugar(gladiador);
    }
}
