package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.TableroB;

public class SinEnergia implements Estado {

    @Override
    public Estado jugar(Gladiador g, TableroB t) {
        g.sumarEnergia(5);
        if (g.conEnergia())
            return new Sano();

        return this;
    }
}
