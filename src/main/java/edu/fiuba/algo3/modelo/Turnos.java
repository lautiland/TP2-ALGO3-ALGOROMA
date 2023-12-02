package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.util.Iterator;
import java.util.List;

public class Turnos {

    private static final int TURNOS_MAXIMOS = 30;
    private int turnosActuales = 0;

    public void ejecutar(List<Gladiador> gladiadores, Tablero tablero) {
        this.turnosActuales += 1;
        Iterator<Gladiador> iterator = gladiadores.iterator();
        while (iterator.hasNext() && !tablero.tieneGanador()) {
            Gladiador gladiador = iterator.next();
            tablero.turnoDe(gladiador);
        }

        if (this.turnosActuales >= TURNOS_MAXIMOS) {
            System.out.println("Nadie Gano");
            throw new SinTurnos();
        }
    }
}
