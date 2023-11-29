package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.JSONReader;
import edu.fiuba.algo3.modelo.Turnos;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnosTest {

    @Test
    public void test01TurnosEliminaUnJugadorCuandoEsteSuperaElLimiteDetiradas() throws IOException {

        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Turnos turnos = new Turnos();
        Gladiador pepe = new Gladiador("Pepe");
        gladiadores.add(pepe);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson("mapaBacanal.json");
        assert mapa != null;

        Tablero tablero = new Tablero(gladiadores, mapa);

        for (int i = 0; i < 25; i++) {
            pepe.modificarEnergia(50);// para que no pierda energia por los tragos
            turnos.ejecutar(gladiadores, tablero);
        }


        assertTrue(gladiadores.isEmpty());
    }
}
