package edu.fiuba.algo3.model.estado;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Lesionado implements Estado {
    @Override
    public Estado jugar(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no avanza, esta lesionado");
        return new Sano();
    }
}
