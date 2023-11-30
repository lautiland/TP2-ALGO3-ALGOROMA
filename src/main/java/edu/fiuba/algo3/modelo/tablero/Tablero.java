package edu.fiuba.algo3.modelo.tablero;

import java.util.*;

import edu.fiuba.algo3.modelo.DataClassCelda;
import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;

public class Tablero {

    private final Celda[][] grillas;
    private final Camino camino;

    public Tablero(List<Gladiador> gladiadores, DataClassTablero mapa) {
        this.grillas = new Celda[mapa.LARGO][mapa.ANCHO];
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(mapa);
        this.construirElResto(mapa);
    }

    public void turnoDe(Gladiador gladiador) {
        gladiador.jugarTurno(this.camino);
    }

    private void crearCaminoEnTablero(DataClassTablero mapa) {
        for (DataClassCelda celdaCamino: mapa.camino) {
            Interactuable premio = InteractuableFactory.crearInteractuable(celdaCamino.premio);
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaCamino.obstaculo);
            Casilla casilla = new Casilla(premio, obstaculo);
            this.camino.agregarCasilla(casilla);
            this.grillas[celdaCamino.X][celdaCamino.Y] = casilla;
        }
    }
    private void construirElResto(DataClassTablero mapa) {
        for (int y = 0; y < mapa.ANCHO; y++) {
            for (int x = 0; x < mapa.LARGO; x++) {
                if (this.grillas[x][y] == null)
                    this.grillas[x][y] = new CeldaSinCasilla();
            }
        }
    }

    public void eliminarGladiador(Gladiador gladiador) {
        this.camino.eliminarGladiadorDeCamino(gladiador);
    }
}
