package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.tablero.Camino;

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
