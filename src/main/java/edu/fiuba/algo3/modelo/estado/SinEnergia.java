package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;

public class SinEnergia implements Estado {

    @Override
    public Estado jugar(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no avanza, esta sin energia, recibe bono de 5 puntos");
        gladiador.modificarEnergia(5);
        return gladiador.actualizarEstado();
    }
}
