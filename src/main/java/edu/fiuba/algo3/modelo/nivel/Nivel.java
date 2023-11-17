package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public interface Nivel {

    void actualizarPuntos(Energia e, int turnosJugados);

    void setGladiador(Gladiador g);

}
