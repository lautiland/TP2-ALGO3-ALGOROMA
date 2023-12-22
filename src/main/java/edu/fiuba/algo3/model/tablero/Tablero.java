package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.view.newView.ObserverCamino;

import java.util.List;

public class Tablero{
    private final Camino camino;
    private final DataClassTablero MAPA;
    private final ObserverCamino observerCamino;

    public Tablero(List<Gladiador> gladiadores, ObserverCamino observerCamino, DataClassTablero mapa) {
        this.MAPA = mapa;
        this.camino = new Camino(gladiadores);
        this.observerCamino = observerCamino;
        this.crearCaminoEnTablero(this.MAPA);
        for (Gladiador gladiador : gladiadores) {
            notificarObserver(gladiador);
        }
    }
    public Tablero(List<Gladiador> gladiadores, DataClassTablero mapa) {
        this.MAPA = mapa;
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(this.MAPA);
        this.observerCamino = new edu.fiuba.algo3.view.newView.Camino();
    }
    public void notificarObserver(Gladiador gladiador) {
        int posicionX = this.obtenerPosicionDe(gladiador).X;
        int posicionY = this.obtenerPosicionDe(gladiador).Y;
        observerCamino.actualizar(gladiador.getNombre(), posicionX, posicionY);
    }
    public void turnoDe(Gladiador gladiador) {
        gladiador.jugarTurno(this.camino);
        notificarObserver(gladiador);
    }

    public DataClassCelda obtenerPosicionDe(Gladiador gladiador) {
        int casillasAvanzadas = this.camino.obtenerPosicionDe(gladiador);
        return this.MAPA.getCeldas().get(casillasAvanzadas);
    }

    private void crearCaminoEnTablero(DataClassTablero mapa) {
        for (DataClassCelda celda : mapa.getCeldas()) {
            Interactuable premio = InteractuableFactory.crearInteractuable(celda.PREMIO);
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(celda.OBSTACULO);
            if (celda.TIPO.equals("llegada")) {
                //TODO: se podría migrar el comportamiento para Casilla
                premio = InteractuableFactory.crearInteractuable("Llegada");
            }
            Casilla casilla = new Casilla(premio, obstaculo);
            this.camino.agregarCasilla(casilla);
        }
    }

    public boolean tieneGanador() {
        return this.camino.tieneGanador();
    }

    public Gladiador obtenerGanador() {
        return this.camino.obtenerGanador();
    }
    public Camino obtenerCamino(){
        return this.camino;
    }
}
