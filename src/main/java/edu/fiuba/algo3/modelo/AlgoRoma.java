package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.Ganador;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoRoma {

    private Tablero tablero;
    private final List<Gladiador> gladiadores = new ArrayList<>();
    private final Turnos turnos = new Turnos();


    public void iniciarJuegoCompleto() throws IOException {
        solicitarNombres();
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson("mapa.json");
        assert mapa != null;
        this.tablero = new Tablero(gladiadores, mapa);
    }

    public void solicitarNombres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos jugadores?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int cant = 1; cant <= cantidad; cant++) {
            System.out.println("Ingrese el nombre del jugador " + cant + ": ");
            String nombre = scanner.nextLine();
            this.gladiadores.add(new Gladiador(nombre, new Dado()));
        }
    }

    public void jugar() {
        while (true) {
            try {
                this.turnos.ejecutar(this.gladiadores, this.tablero);
            } catch (Ganador | SinTurnos e) {
                break;
            }
        }
    }
}
