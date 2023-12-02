package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Llegada implements Interactuable{
    @Override
    public void interactuarCon(Gladiador gladiador, Camino camino) {
        if (gladiador.abrirPuerta(camino)){
            camino.reclamarPremio();
        }
    }
}