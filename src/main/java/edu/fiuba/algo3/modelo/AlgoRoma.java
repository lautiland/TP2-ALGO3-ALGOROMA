package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgoRoma {

    private Tablero tablero;
    private final List<Gladiador> gladiadores = new ArrayList<>();
    private final Turnos turnos = new Turnos();

    public void iniciarJuegoCompleto(String rutaDelMapa) throws IOException {
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson(rutaDelMapa);
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
}
