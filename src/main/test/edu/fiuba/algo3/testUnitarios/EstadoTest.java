package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Lesionado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;
import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EstadoTest {

    @Test
    public void test01DeLesionadoSePasaASano() {
        //Act
        Gladiador pepe = new Gladiador("Pepe", new Dado());
        Estado lesionado = new Lesionado();

        //Arrange
        Estado nuevoEstado = lesionado.jugar(pepe);

        //Assert
        assertTrue(nuevoEstado instanceof Sano);
    }

    @Test
    public void test02NoSeJuegaSiEstaLesionado() {
        Dado dadoMock = mock(Dado.class, "Dado");
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador pepe = new Gladiador("Pepe", dadoMock);
        Camino camino = new Camino(List.of(pepe));
        Interactuable sinInteractuable = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable("Lesion");
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, obstaculo));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));

        pepe.jugarTurno(camino);

        assertTrue(camino.estaEl(pepe, 1));
        pepe.jugarTurno(camino);
        pepe.jugarTurno(camino);
        assertTrue(camino.estaEl(pepe, 2));
    }
}