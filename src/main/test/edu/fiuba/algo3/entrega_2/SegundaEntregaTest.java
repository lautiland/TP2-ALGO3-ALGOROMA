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
    private static final int TABLERO_LARGO = 19;
    private static final int TABLERO_ANCHO = 11;
    private static final int TABLERO_CANTIDAD_ELEMENTOS = 38;
    private static final int ELEMENTO_CON_LESION_COMIDA = 26;
    private static final int ULTIMA_CELDA_X = 17;
    private static final int CELDA_RANDOM_X = 13;
    private static final int PRIMER_CELDA_X = 1;
    private static final int ULTIMA_CELDA_Y = 1;
    private static final String SIN_INTERACTUABLE = "";
    private static final int PRIMER_CELDA_Y = 7;
    private static final int CELDA_RANDOM_Y = 9;
    private static final String CELDA_RANDOM_OBSTACULO = "Lesion";
    private static final String CELDA_RANDOM_PREMIO = "Comida";
    private static final int PUNTOS_DESPUES_UN_TRAGO = 15;
    private static final int PUNTOS_DESPUES_UN_TRAGO_FIERA = -5;
    private static final int PUNTOS_DESPUES_COMIDA = 30;
    private static final int PUNTOS_DESPUES_COMIDA_BACANAL = 25;

    private static final int PUNTOS_DESPUES_COMIDA_BACANAL_ARMADURA_FIERA = 15;
    private Dado dadoMock;
    private static Logger loggerMock;

    @BeforeEach
    public void beforeEach() {
        dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(PRIMER_CELDA_X);
        loggerMock = mock(Logger.class);
        new Logger(loggerMock);
    }

    @Test
    public void test13ElJSONDelMapaEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(TABLERO_ANCHO, DataTablero.ANCHO);
        assertEquals(TABLERO_LARGO, DataTablero.LARGO);
    }

    @Test
    public void test14ElJSONDeLosObstaculosEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(TABLERO_CANTIDAD_ELEMENTOS, DataTablero.getCamino().size());

        DataClassCelda primerCelda = DataTablero.getCamino().get(0);
        DataClassCelda ultimaCelda = DataTablero.getLlegada();
        DataClassCelda celdaConDosObstaculos = DataTablero.getCamino().get(ELEMENTO_CON_LESION_COMIDA);

        assertEquals(PRIMER_CELDA_X, primerCelda.X);
        assertEquals(PRIMER_CELDA_Y, primerCelda.Y);
        assertEquals(SIN_INTERACTUABLE, primerCelda.OBSTACULO);
        assertEquals(SIN_INTERACTUABLE, primerCelda.PREMIO);

        assertEquals(ULTIMA_CELDA_X, ultimaCelda.X);
        assertEquals(ULTIMA_CELDA_Y, ultimaCelda.Y);
        assertEquals(SIN_INTERACTUABLE, ultimaCelda.OBSTACULO);
        assertEquals(SIN_INTERACTUABLE, ultimaCelda.PREMIO);

        assertEquals(CELDA_RANDOM_X, celdaConDosObstaculos.X);
        assertEquals(CELDA_RANDOM_Y, celdaConDosObstaculos.Y);
        assertEquals(CELDA_RANDOM_OBSTACULO, celdaConDosObstaculos.OBSTACULO);
        assertEquals(CELDA_RANDOM_PREMIO, celdaConDosObstaculos.PREMIO);
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
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_DESPUES_UN_TRAGO));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus se lesiono");
        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus no avanza, esta lesionado");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus encontró una fiera");
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_DESPUES_UN_TRAGO_FIERA));
    }

    @Test
    public void test16ElJuegoParseaLosPremiosCorrectamente() throws IOException {
        AlgoRoma algoRoma = new AlgoRoma();
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        algoRoma.agregarGladiador(gladiador);
        algoRoma.iniciarJuegoCompleto("src/main/test/edu/fiuba/algo3/entrega_2/examples/mapaPremios.json");

        algoRoma.jugarTurno();
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_DESPUES_COMIDA));

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
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_DESPUES_COMIDA_BACANAL));

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe casco");
        verify(loggerMock).info("El gladiador Atticus se lesiono");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador Atticus no avanza, esta lesionado");

        algoRoma.jugarTurno();
        verify(loggerMock).info("El gladiador recibe una armadura"); // Se aplica primero el premio luego el obstaculo!
        verify(loggerMock).info("El gladiador Atticus encontró una fiera");
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_DESPUES_COMIDA_BACANAL_ARMADURA_FIERA));

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


