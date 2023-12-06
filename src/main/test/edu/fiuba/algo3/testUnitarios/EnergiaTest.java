package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Energia;
import edu.fiuba.algo3.model.estado.Estado;
import edu.fiuba.algo3.model.estado.Sano;
import edu.fiuba.algo3.model.estado.SinEnergia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class EnergiaTest {

    @Test
    public void test01AtualizarSinEnergia() {
        // Arrange
        Energia energia = new Energia();
        Estado estadoMock = mock(Estado.class);

        //Act
        energia.modificarPuntos(-20);

        //Assert
        assertTrue(energia.actualizarEstado(estadoMock) instanceof SinEnergia);
    }

    @Test
    public void testAtualizarSinEnergiaNoCambiaEstado() {
        // Arrange
        Energia energia = new Energia();
        Estado estadoMock = mock(Estado.class);

        // Assert
        assertSame(estadoMock, energia.actualizarEstado(estadoMock));
    }

    @Test
    public void testAtualizarEstadoConEnergia() {
        // Arrange
        Energia energia = new Energia();
        Estado estadoSano = new Sano();
        Estado estadoLesionado = new SinEnergia();

        assertSame(estadoSano, energia.actualizarEstado(estadoSano));
        assertSame(estadoLesionado, energia.actualizarEstado(estadoLesionado));

        //Act
        energia.modificarPuntos(-20);

        //Assert
        assertTrue(energia.actualizarEstado(estadoSano) instanceof SinEnergia);
    }
}


