package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.DataClassCelda;
import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;

import java.util.List;

public class Tablero {

    private final Celda[][] grillas;
    private final Camino camino;

    public Tablero(List<Gladiador> gladiadores, DataClassTablero mapa) {
        this.grillas = new Celda[mapa.getLARGO()][mapa.getANCHO()];
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(mapa);
        this.construirElResto(mapa);
    }

    public void turnoDe(Gladiador gladiador) {
        gladiador.jugarTurno(this.camino);
    }

    private void crearCaminoEnTablero(DataClassTablero mapa) {
        for (DataClassCelda celdaCamino : mapa.getCamino()) {
            Interactuable premio = InteractuableFactory.crearInteractuable(celdaCamino.getPremio());
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaCamino.getObstaculo());
            Casilla casilla = new Casilla(premio, obstaculo);
            this.camino.agregarCasilla(casilla);
            this.grillas[celdaCamino.getX()][celdaCamino.getY()] = casilla;
        }
        DataClassCelda celdaLlegada = mapa.getLlegada();
        Interactuable premio = InteractuableFactory.crearInteractuable("Llegada");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaLlegada.getObstaculo());
        Casilla casilla = new Casilla(premio, obstaculo);
        this.camino.agregarCasilla(casilla);
        this.grillas[celdaLlegada.getX()][celdaLlegada.getY()] = casilla;
    }

    private void construirElResto(DataClassTablero mapa) {
        for (int y = 0; y < mapa.getANCHO(); y++) {
            for (int x = 0; x < mapa.getLARGO(); x++) {
                if (this.grillas[x][y] == null)
                    this.grillas[x][y] = new CeldaSinCasilla();
            }
        }
    }

    public boolean tieneGanador() {
        return this.camino.tieneGanador();
    }

    public Gladiador obtenerGanador() {
        return this.camino.obtenerGanador();
    }
}
