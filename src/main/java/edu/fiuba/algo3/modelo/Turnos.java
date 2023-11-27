package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.Ganador;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.util.List;

public class Turnos {

    private static final int TURNOS_MAXIMOS = 30;
    private int turnosActuales = 0;

    public void ejecutar(List<Gladiador> gladiadores, Tablero tablero) {
        this.turnosActuales += 1;
        for (Gladiador gladiador : gladiadores) {
            tablero.turnoDe(gladiador);
        }

        if (this.turnosActuales >= TURNOS_MAXIMOS) {
            throw new SinTurnos();
        }
    }

}
