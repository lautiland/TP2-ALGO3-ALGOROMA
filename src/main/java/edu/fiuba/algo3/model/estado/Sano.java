package edu.fiuba.algo3.model.estado;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public class Sano implements Estado {

    @Override
    public Estado jugar(Gladiador gladiador) {
        gladiador.actualizarSeniority();
        return gladiador.actualizarEstado();
    }

    @Override
    public Estado jugar(Gladiador gladiador, Camino camino) {
        int tirada = gladiador.calcularMovimientos();
        Logger.getInstance().info("Gladiador " + gladiador.getNombre() + " tira el dado, avanza " + tirada + " casillas");
        camino.mover(gladiador, tirada);
        return jugar(gladiador);
    }
}
