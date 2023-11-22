package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.TableroB;

public class Sano implements Estado {

    @Override
    public Estado jugar(Gladiador g, TableroB t) {
        Dado dado = new Dado();
        t.mover(g, 7);
        g.actualizarPuntosSegunNivel();
        if (g.sinEnergia()) {

            return new SinEnergia();}

        return this;
    }
}
