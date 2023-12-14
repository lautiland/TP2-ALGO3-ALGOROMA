package edu.fiuba.algo3.model.estado;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public class SinEnergia implements Estado {
    @Override
    public Estado jugar(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no avanza, esta sin energia, recibe bono de 5 puntos");
        gladiador.modificarEnergia(5);
        return gladiador.obtenerPuntosEnergia() > 0 ? new Sano() : this;
    }
}
