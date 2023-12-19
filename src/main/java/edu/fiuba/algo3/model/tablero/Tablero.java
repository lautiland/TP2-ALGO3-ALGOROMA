package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.view.newView.ObserverTablero;

import java.util.ArrayList;
import java.util.List;

public class Tablero{
    private final Celda[][] grilla;
    private final Camino camino;
    private final DataClassTablero MAPA;
    private ObserverTablero observerTablero;

    public Tablero(List<Gladiador> gladiadores, ObserverTablero observerTablero, DataClassTablero mapa) {
        this.MAPA = mapa;
        this.grilla = new Celda[this.MAPA.LARGO][this.MAPA.ANCHO];
        this.camino = new Camino(gladiadores);
        this.observerTablero = observerTablero;
        this.crearCaminoEnTablero(this.MAPA);
        this.construirElResto(this.MAPA);
        for (Gladiador gladiador : gladiadores) {
            notificarObserver(gladiador);
        }
    }
    public Tablero(List<Gladiador> gladiadores, DataClassTablero mapa) {
        this.MAPA = mapa;
        this.grilla = new Celda[this.MAPA.LARGO][this.MAPA.ANCHO];
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(this.MAPA);
        this.construirElResto(this.MAPA);
    }
    public void notificarObserver(Gladiador gladiador) {
        int posicionX = this.obtenerPosicionDe(gladiador).X;
        int posicionY = this.obtenerPosicionDe(gladiador).Y;
        observerTablero.actualizar(gladiador.getNombre(), posicionX, posicionY);
    }
    public void turnoDe(Gladiador gladiador) {
        gladiador.jugarTurno(this.camino);
        notificarObserver(gladiador);
    }

    public DataClassCelda obtenerPosicionDe(Gladiador gladiador) {
        int casillasAvanzadas = this.camino.obtenerPosicionDe(gladiador);
        return MAPA.getCamino().get(casillasAvanzadas);
    }

    private void crearCaminoEnTablero(DataClassTablero mapa) {
        for (DataClassCelda celdaCamino : mapa.getCamino()) {
            Interactuable premio = InteractuableFactory.crearInteractuable(celdaCamino.PREMIO);
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(celdaCamino.OBSTACULO);
            Casilla casilla = new Casilla(premio, obstaculo);
            this.camino.agregarCasilla(casilla);
            this.grilla[celdaCamino.X][celdaCamino.Y] = casilla;
        }
        DataClassCelda celdaLlegada = mapa.getLlegada();
        Interactuable premioLlegada = InteractuableFactory.crearInteractuable("Llegada");
        Interactuable obstaculoLlegada = InteractuableFactory.crearInteractuable(celdaLlegada.OBSTACULO);
        Casilla casillaLlegada = new Casilla(premioLlegada, obstaculoLlegada);
        this.camino.agregarCasilla(casillaLlegada);
        this.grilla[celdaLlegada.X][celdaLlegada.Y] = casillaLlegada;
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
