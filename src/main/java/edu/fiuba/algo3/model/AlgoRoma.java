package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.JuegoSinGladiadores;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.model.parser.JuegoParser;
import edu.fiuba.algo3.model.tablero.Tablero;
import edu.fiuba.algo3.view.newView.ObserverEquipamiento;
import edu.fiuba.algo3.view.newView.ObserverTablero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgoRoma {

    private Tablero tablero;
    private final List<Gladiador> gladiadores = new ArrayList<>();
    private Turnos turnos;

    public void iniciarJuegoCompleto(String rutaDelMapa, ObserverTablero observerTablero) throws IOException {
        if (gladiadores.isEmpty()) {
            Logger.getInstance().error("No hay gladiadores para iniciar el juego, agregue gladiadores primero");
            throw new JuegoSinGladiadores();
        }
        JuegoParser parser = new JuegoParser();
        DataClassTablero mapa = parser.parsear(rutaDelMapa, "json");
        this.tablero = new Tablero(gladiadores, observerTablero, mapa);
        this.turnos = new Turnos(gladiadores);
    }
    public void iniciarJuegoCompleto(String rutaDelMapa) throws IOException {
        if (gladiadores.isEmpty()) {
            Logger.getInstance().error("No hay gladiadores para iniciar el juego, agregue gladiadores primero");
            throw new JuegoSinGladiadores();
        }
        JuegoParser parser = new JuegoParser();
        DataClassTablero mapa = parser.parsear(rutaDelMapa, "json");
        this.tablero = new Tablero(gladiadores, mapa);
        this.turnos = new Turnos(gladiadores);
    }

    public void agregarGladiador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);
    }

    public void agregarGladiador(String nombre, ObserverEquipamiento observerEquipamiento) {
        Logger.getInstance().info("Se agrego el gladiador " + nombre);
        Gladiador gladiador = new Gladiador(nombre, new Dado(), observerEquipamiento);
        this.gladiadores.add(gladiador);
    }

    public void jugarTurno() {
        this.turnos.ejecutar(this.gladiadores, this.tablero);
    }

    public boolean tieneGanador() {
        return this.tablero.tieneGanador();
    }

    public Gladiador obtenerGanador() {
        return this.tablero.obtenerGanador();
    }

    public Tablero obtenerTablero() {
        return this.tablero;
    }

    public Gladiador obtenerJugadorActual() {
        return this.turnos.obtenerJugadorActual();
    }
}
