package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Senior implements Nivel {

    private Gladiador gladiador;
    @Override
    public void actualizarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(10);
    }

    @Override
    public void setGladiador(Gladiador g) {
        this.gladiador = g;
    }
}
