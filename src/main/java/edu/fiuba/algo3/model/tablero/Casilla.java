package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;

public class Casilla implements Celda {

    private final Interactuable premio;
    private final Interactuable obstaculo;

    public Casilla(Interactuable premio, Interactuable obstaculo) {
        this.premio = premio;
        this.obstaculo = obstaculo;
    }

    public void interactuarCon(Gladiador gladiador, Camino camino) {
        this.premio.interactuarCon(gladiador, camino);
        this.obstaculo.interactuarCon(gladiador, camino);
    }
}
