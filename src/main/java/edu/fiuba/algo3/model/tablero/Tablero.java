package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;

import java.util.List;

public class Tablero {

    private final Celda[][] grilla;
    private final Camino camino;

    public Tablero(List<Gladiador> gladiadores, DataClassTablero mapa) {
        this.grilla = new Celda[mapa.LARGO][mapa.ANCHO];
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(mapa);
        this.construirElResto(mapa);
    }

    public void turnoDe(Gladiador gladiador) {
        gladiador.jugarTurno(this.camino);
    }

    private void crearCaminoEnTablero(DataClassTablero mapa) {
        for (DataClassCelda celdaCamino : mapa.getCamino()) {
            Interactuable premio = InteractuableFactory.crearInteractuable(celdaCamino.premio);
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaCamino.obstaculo);
            Casilla casilla = new Casilla(premio, obstaculo);
            this.camino.agregarCasilla(casilla);
            this.grilla[celdaCamino.X][celdaCamino.Y] = casilla;
        }
        DataClassCelda celdaLlegada = mapa.getLlegada();
        Interactuable premio = InteractuableFactory.crearInteractuable("Llegada");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaLlegada.obstaculo);
        Casilla casilla = new Casilla(premio, obstaculo);
        this.camino.agregarCasilla(casilla);
        this.grilla[celdaLlegada.X][celdaLlegada.Y] = casilla;
    }

    private void construirElResto(DataClassTablero mapa) {
        for (int y = 0; y < mapa.ANCHO; y++) {
            for (int x = 0; x < mapa.LARGO; x++) {
                if (this.grilla[x][y] == null)
                    this.grilla[x][y] = new CeldaSinCasilla();
            }
        }
    }

    public boolean tieneGanador() {
        return this.camino.tieneGanador();
    }

    public Gladiador obtenerGanador() {
        return this.camino.obtenerGanador();
    }
    public Celda[][] obtenerGrilla() {
        return this.grilla;
    }
}
