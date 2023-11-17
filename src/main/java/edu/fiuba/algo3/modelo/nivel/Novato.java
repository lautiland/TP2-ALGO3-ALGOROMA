package edu.fiuba.algo3.modelo.nivel;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Novato implements Nivel {

    private Gladiador gladiador;
    @Override
    public void actualizarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(0);
        if (turnosJugados == 8)
            gladiador.setNivel(new SemiSenior());

    }
    @Override
    public void setGladiador(Gladiador g) {
        this.gladiador = g;
    }

}
