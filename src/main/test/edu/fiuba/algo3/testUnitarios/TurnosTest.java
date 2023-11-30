package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnosTest {

    @Test
    public void test01TurnosEliminaUnJugadorCuandoEsteSuperaElLimiteDetiradas() throws IOException {

        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Turnos turnos = new Turnos();
        Gladiador gladiador = new Gladiador("Marcus", new Dado());
        gladiadores.add(gladiador);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson("mapaBacanal.json");

        Tablero tablero = new Tablero(gladiadores, mapa);

        for (int i = 0; i < 25; i++) {
            gladiador.modificarEnergia(50);// para que no pierda energia por los tragos
            turnos.ejecutar(gladiadores, tablero);
        }


        assertTrue(gladiadores.isEmpty());
    }
}
