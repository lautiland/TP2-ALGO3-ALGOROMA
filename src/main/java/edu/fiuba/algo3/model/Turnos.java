package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.SinTurnos;
import edu.fiuba.algo3.model.tablero.Tablero;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Turnos {
    private static final int TURNOS_MAXIMOS = 30;
    private int turnosActuales = 0;
    private final Queue<Gladiador> gladiadoresSinJugar = new ArrayDeque<>();
    private Gladiador jugadorActual;

    public Turnos(List<Gladiador> gladiadores) {
        gladiadoresSinJugar.addAll(gladiadores);
        jugadorActual = gladiadoresSinJugar.poll();
    }

    public void ejecutar(List<Gladiador> gladiadores, Tablero tablero) {
        if (gladiadoresSinJugar.isEmpty()) {
            gladiadoresSinJugar.addAll(gladiadores);
            turnosActuales++;
        }
        tablero.turnoDe(jugadorActual); //TODO:Solo es null cuando se recibe asi
        if (this.turnosActuales >= TURNOS_MAXIMOS) {
            Logger.getInstance().error("Se han acabado los turnos, no hay ganador");
            throw new SinTurnos();
        }
        jugadorActual = gladiadoresSinJugar.poll();
    }

    public Gladiador obtenerJugadorActual() {
        return this.jugadorActual;
    }
}
