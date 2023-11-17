package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class SemiSenior implements Nivel {

    private Gladiador gladiador;
    @Override
    public void actualizarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(5);
        if (turnosJugados == 9)
            this.gladiador.setNivel(new Senior());
    }

    @Override
    public void setGladiador(Gladiador g) {
        this.gladiador = g;
    }
}
