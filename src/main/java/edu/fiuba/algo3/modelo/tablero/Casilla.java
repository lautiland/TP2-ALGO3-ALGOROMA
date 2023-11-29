package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;

public class Casilla implements Celda {

    private final Interactuable premio;
    private final Interactuable obstaculo;

    public Casilla(Interactuable premio, Interactuable obstaculo) {
        this.premio = premio;
        this.obstaculo = obstaculo;
    }
    public void interactuarCon(Gladiador gladiador) {
        this.premio.interactuarCon(gladiador);
        this.obstaculo.interactuarCon(gladiador);
    }
}
