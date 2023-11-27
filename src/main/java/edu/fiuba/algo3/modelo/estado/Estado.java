package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepciones.Ganador;

public interface Estado {

    Estado jugar(Gladiador g);

    default Estado jugar(Gladiador g, Camino camino) {
        return jugar(g);
    }
}
