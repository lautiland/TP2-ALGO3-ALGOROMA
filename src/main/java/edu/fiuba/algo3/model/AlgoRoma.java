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
    private final Turnos turnos = new Turnos();

    public void iniciarJuegoCompleto(String rutaDelMapa, ArrayList<Gladiador> gladiadores) throws IOException {
        for (Gladiador gladiador : gladiadores) {
            this.agregarGladiador(gladiador);
        }
        this.iniciarJuegoCompleto(rutaDelMapa);
    }
    public void iniciarJuegoCompleto(String rutaDelMapa) throws IOException {
        if (gladiadores.isEmpty()) {
            Logger.getInstance().error("No hay gladiadores para iniciar el juego, agregue gladiadores primero");
            throw new JuegoSinGladiadores();
        }

        JuegoParser parser = new JuegoParser();
        DataClassTablero mapa = parser.parsear(rutaDelMapa, "json");
        this.tablero = new Tablero(gladiadores, mapa);
    }

    public void agregarGladiador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);
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
}
