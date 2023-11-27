package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;

public class SinEnergia implements Estado {

    @Override
    public Estado jugar(Gladiador g) {
        System.out.print("No avanzas, estas sin energia, recibis bono de 5 puntos ");
        g.modificarEnergia(5);
        return g.actualzarEstadoConEnergia();
    }
}
