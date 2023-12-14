package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlgoRomaTest {
    @Test
    public void test01PuedoObtenerElJugadorActual() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();

        algoRoma.agregarGladiador("Atticus");
        algoRoma.iniciarJuegoCompleto("mapa.json");

        assertEquals("Atticus", algoRoma.obtenerJugadorActual().getNombre());
    }

    @Test
    public void test02PuedoObtenerElTableroCorrecto() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();

        algoRoma.agregarGladiador("Atticus");
        algoRoma.iniciarJuegoCompleto("mapa.json");

        assertEquals(1, algoRoma.obtenerTablero().obtenerPosicionDe(algoRoma.obtenerJugadorActual()).X);
        assertEquals(7, algoRoma.obtenerTablero().obtenerPosicionDe(algoRoma.obtenerJugadorActual()).Y);
    }

    @Test
    public void test03SePuedeGanarEnUnMapaSimple() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);

        algoRoma.agregarGladiador(gladiador);
        algoRoma.iniciarJuegoCompleto("src/main/test/edu/fiuba/algo3/testUnitarios/examples/mapaSimple.json");

        assertFalse(algoRoma.tieneGanador());

        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();

        assertTrue(algoRoma.tieneGanador());
        assertEquals("Atticus", algoRoma.obtenerGanador().getNombre());
    }
}
