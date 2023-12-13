package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.estado.Estado;
import edu.fiuba.algo3.model.estado.Lesionado;
import edu.fiuba.algo3.model.estado.Sano;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Camino;
import edu.fiuba.algo3.model.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EstadoTest {

    @Test
    public void test01DeLesionadoSePasaASano() {
        //Act
        Gladiador gladiador = new Gladiador("Augustus", new Dado());
        Estado lesionado = new Lesionado();

        //Arrange
        Estado nuevoEstado = lesionado.jugar(gladiador, null);

        //Assert
        assertTrue(nuevoEstado instanceof Sano);
    }

    @Test
    public void test02NoSeJuegaSiEstaLesionado() {
        Dado dadoMock = mock(Dado.class, "Dado");
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador gladiador = new Gladiador("Augustus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable sinInteractuable = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable("Lesion");
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, obstaculo));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));

        gladiador.jugarTurno(camino);

        assertTrue(camino.estaEl(gladiador, 1));
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        assertTrue(camino.estaEl(gladiador, 2));
    }

    @Test
    public void test03SigueJugandoSinEnergiaDespuesDeRecuperar() {
        Dado dadoMock = mock(Dado.class, "Dado");
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador gladiador = new Gladiador("Augustus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable sinInteractuable = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable Fiera = InteractuableFactory.crearInteractuable("Fiera");
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, Fiera));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));

        gladiador.jugarTurno(camino);// Se encuentra a la fiera
        gladiador.jugarTurno(camino); // Recupera energia
        gladiador.jugarTurno(camino);

        assertTrue(camino.estaEl(gladiador, 2));
    }

    @Test
    public void test04NoSeMueveSinEnergia() {
        Dado dadoMock = mock(Dado.class, "Dado");
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador gladiador = new Gladiador("Augustus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable sinInteractuable = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable Fiera = InteractuableFactory.crearInteractuable("Fiera");
        Interactuable bacanal = InteractuableFactory.crearInteractuable("Bacanal");
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, Fiera));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, bacanal));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));

        gladiador.jugarTurno(camino);// Se encuentra a la fiera y se queda sin energia
        gladiador.jugarTurno(camino); // Recupera energia, 5 energia
        when(dadoMock.tirar()).thenReturn(6);
        gladiador.jugarTurno(camino); // Se encuentra al bacanal, 5-30 = -25 energia
        assertEquals(-25, gladiador.obtenerPuntosEnergia());
        assertEquals(7, camino.obtenerPosicionDe(gladiador));

        when(dadoMock.tirar()).thenReturn(1);
        gladiador.jugarTurno(camino); // No se mueve, -20Puntos
        assertEquals(-20, gladiador.obtenerPuntosEnergia());
        assertEquals(7, camino.obtenerPosicionDe(gladiador));

        when(dadoMock.tirar()).thenReturn(1);
        gladiador.jugarTurno(camino); // No se mueve -15Puntos
        assertEquals(-15, gladiador.obtenerPuntosEnergia());
        assertEquals(7, camino.obtenerPosicionDe(gladiador));
    }
}
