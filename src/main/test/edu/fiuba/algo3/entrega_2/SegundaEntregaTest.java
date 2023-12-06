package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.excepciones.JuegoSinGladiadores;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.model.parser.JuegoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SegundaEntregaTest {
    private Dado dadoMock;
    private static Logger loggerMock;

    @BeforeEach
    public void beforeEach() {
        dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        loggerMock = mock(Logger.class);
        new Logger(loggerMock);
    }

    @Test
    public void test13ElJSONDelMapaEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(10, DataTablero.ANCHO);
        assertEquals(18, DataTablero.LARGO);
    }

    @Test
    public void test14ElJSONDeLosObstaculosEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(38, DataTablero.getCamino().size());

        DataClassCelda primerCelda = DataTablero.getCamino().get(0);
        DataClassCelda ultimaCelda = DataTablero.getLlegada();
        DataClassCelda celdaConDosObstaculos = DataTablero.getCamino().get(26);

        assertEquals(1, primerCelda.X);
        assertEquals(7, primerCelda.Y);
        assertEquals("", primerCelda.obstaculo);
        assertEquals("", primerCelda.premio);

        assertEquals(17, ultimaCelda.X);
        assertEquals(1, ultimaCelda.Y);
        assertEquals("", ultimaCelda.obstaculo);
        assertEquals("", ultimaCelda.premio);

        assertEquals(13, celdaConDosObstaculos.X);
        assertEquals(9, celdaConDosObstaculos.Y);
        assertEquals("Lesion", celdaConDosObstaculos.obstaculo);
        assertEquals("Comida", celdaConDosObstaculos.premio);
    }


    @Test
    public void test15ElJuegoParseaLosObstaculosCorrectamente() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        algoRoma.agregarGladiador(gladiador);
        algoRoma.iniciarJuegoCompleto("src/main/test/edu/fiuba/algo3/entrega_2/examples/mapaObstaculos.json");

        algoRoma.jugarTurno();
        verify(loggerMock).info("Gladiador Atticus cayó en una Bacanal");
        verify(loggerMock).info("Tiraste 1, tomas 1 tragos, perdes 5 puntos ");
        assertTrue(gladiador.tenesPuntosDeEnegia(15));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus se lesiono");
        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus no avanza, esta lesionado");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus encontró una fiera");
        assertTrue(gladiador.tenesPuntosDeEnegia(-5));
    }

    @Test
    public void test16ElJuegoParseaLosPremiosCorrectamente() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        algoRoma.agregarGladiador(gladiador);
        algoRoma.iniciarJuegoCompleto("src/main/test/edu/fiuba/algo3/entrega_2/examples/mapaPremios.json");

        algoRoma.jugarTurno();
        assertTrue(gladiador.tenesPuntosDeEnegia(30));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe casco");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe una armadura");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe un escudo y una espada");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe una llave");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador cayo en una casilla de mejora pero ya esta al máximo");
    }

    @Test
    public void test17ElJuegoSeCreaAcordeAlJSON() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        algoRoma.agregarGladiador(gladiador);
        algoRoma.iniciarJuegoCompleto("src/main/test/edu/fiuba/algo3/entrega_2/examples/mapaCompleto.json");

        algoRoma.jugarTurno();
        assertTrue(gladiador.tenesPuntosDeEnegia(25));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe casco");
        verify(loggerMock).info("El gladiador Atticus se lesiono");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus no avanza, esta lesionado");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe una armadura"); // Se aplica primero el premio luego el obstaculo!
        verify(loggerMock).info("El gladiador Atticus encontró una fiera");
        assertTrue(gladiador.tenesPuntosDeEnegia(15));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe un escudo y una espada");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe una llave");

        algoRoma.jugarTurno();
        verify(loggerMock, atLeastOnce()).info("Gladiador Atticus tira el dado, avanza 1 casillas");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus abrió la puerta con la llave");

        assertEquals(gladiador, algoRoma.obtenerGanador());
    }

    @Test
    public void test18VerificarLogger() {
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        AlgoRoma algoRoma = new AlgoRoma();

        verify(loggerMock, never()).info(anyString());
        verify(loggerMock, never()).error(anyString());


        gladiador.modificarEnergia(10);
        verify(loggerMock).info("El gladiador ahora tiene 30 puntos de energía");

        assertThrows(JuegoSinGladiadores.class, () -> algoRoma.iniciarJuegoCompleto("mapa.json"));
        verify(loggerMock).error("No hay gladiadores para iniciar el juego, agregue gladiadores primero");
    }
}


