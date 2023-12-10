package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.JuegoSinGladiadores;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.model.parser.JuegoParser;
import edu.fiuba.algo3.model.tablero.Tablero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgoRoma {

    private Tablero tablero;
    private final List<Gladiador> gladiadores = new ArrayList<>();
    private Turnos turnos;

    public void iniciarJuegoCompleto(String rutaDelMapa) throws IOException {
        if (gladiadores.isEmpty()) {
            Logger.getInstance().error("No hay gladiadores para iniciar el juego, agregue gladiadores primero");
            throw new JuegoSinGladiadores();
        }

        JuegoParser parser = new JuegoParser();
        DataClassTablero mapa = parser.parsear(rutaDelMapa, "json");
        this.tablero = new Tablero(gladiadores, mapa);
        this.turnos = new Turnos(gladiadores.get(0));
    }

    // TODO: Sacar si no se usa?
    public void agregarGladiador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);
    }

    public void agregarGladiador(String nombre) {
        Logger.getInstance().info("Se agrego el gladiador " + nombre);
        this.gladiadores.add(new Gladiador(nombre, new Dado()));
    }

    public void jugarTurno() {
        this.turnos.ejecutar(this.gladiadores, this.tablero);
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
