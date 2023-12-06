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
        Estado nuevoEstado = lesionado.jugar(gladiador);

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
}
