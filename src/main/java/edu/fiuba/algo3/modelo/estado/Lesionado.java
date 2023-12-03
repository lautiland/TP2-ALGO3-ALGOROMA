package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;

public class Lesionado implements Estado {
    @Override
    public Estado jugar(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no avanza, esta lesionado");
        return new Sano();
    }
}
