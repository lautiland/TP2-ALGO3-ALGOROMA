package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
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

    public String nombrePremio() {
        return this.premio.toString();
    }

    public String nombreObstaculo() {
        return this.obstaculo.toString();
    }

    @Override
    public boolean equals(String tipo) {
        return false; // Para que no lo tome como casilla vacia
    }
}
