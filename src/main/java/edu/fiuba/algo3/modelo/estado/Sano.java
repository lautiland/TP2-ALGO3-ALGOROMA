package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Sano implements Estado {

    @Override
    public Estado jugar(Gladiador gladiador) {
        gladiador.actualizarSeniority();
        return gladiador.actualizarEstado();
    }

    @Override
    public Estado jugar(Gladiador gladiador, Camino camino) {
        System.out.println("Tirar dado");
        int tirada = gladiador.calcularMovimientos();
        System.out.print("Tiraste: " + tirada + " , avanzas " + tirada + " casillas");
        camino.mover(gladiador, tirada);
        return jugar(gladiador);
    }
}
