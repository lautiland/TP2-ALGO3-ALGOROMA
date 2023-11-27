package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;

public class Casilla implements Celda {

    private final Interactuable premio;
    private final Interactuable obstaculo;

    public Casilla(Interactuable p, Interactuable o) {
        this.premio = p;
        this.obstaculo = o;
    }
    public void interactuarCon(Gladiador g) {
        this.premio.interactuarCon(g);
        this.obstaculo.interactuarCon(g);
    }
}
