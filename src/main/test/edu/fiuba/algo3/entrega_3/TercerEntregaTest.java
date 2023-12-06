package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.excepciones.SinTurnos;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TercerEntregaTest {
    @Test
    public void test19ElJugadorGanaUnaPartida() throws IOException {
        AlgoRoma juego = new AlgoRoma();
        Dado dadoMock = mock(Dado.class);
        Gladiador ignacius = new Gladiador("Ignacius", dadoMock);
        Gladiador maximus = new Gladiador("Maximus", new Dado());
        juego.agregarGladiador(ignacius);
        juego.agregarGladiador(maximus);
        juego.iniciarJuegoCompleto("mapa.json");

        when(dadoMock.tirar()).thenReturn(1);
        juego.jugarTurno(); // Casco
        when(dadoMock.tirar()).thenReturn(5);
        juego.jugarTurno(); // Nada
        when(dadoMock.tirar()).thenReturn(3);
        juego.jugarTurno(); // Armadura, Fiera (-10)
        when(dadoMock.tirar()).thenReturn(6);
        juego.jugarTurno(); // Escudo y espada
        juego.jugarTurno(); // Llave
        juego.jugarTurno(); // Fiera (-10)
        juego.jugarTurno(); // Nada
        juego.jugarTurno();

        assertEquals(juego.obtenerGanador(), ignacius);
    }

    @Test
    public void test20ElJugadorPierdeUnaPartida() throws IOException {
        AlgoRoma juego = new AlgoRoma();
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador ignacius = new Gladiador("Ignacius", dadoMock);
        Gladiador maximus = new Gladiador("Maximus", dadoMock);
        juego.agregarGladiador(ignacius);
        juego.agregarGladiador(maximus);
        juego.iniciarJuegoCompleto("mapa.json");

        assertThrows(SinTurnos.class, () -> {
            for (int i = 0; i < 30; i++) {
                juego.jugarTurno();
            }
        });
    }
}
