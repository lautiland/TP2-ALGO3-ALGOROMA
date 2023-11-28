package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.estado.SinEnergia;
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
        assertTrue(energia.atualizarSinEnergia(estadoMock) instanceof SinEnergia);
    }

    @Test
    public void testAtualizarConEnergia() {
        //Arrange
        Energia energia = new Energia();
        Estado estadoMock = mock(Estado.class);

        // Act y Arrange
        assertTrue(energia.atualizarConEnergia(estadoMock) instanceof Sano);
    }

    @Test
    public void testAtualizarSinEnergiaNoCambiaEstado() {
        // Arrange
        Energia energia = new Energia();
        Estado estadoMock = mock(Estado.class);

        // Assert
        assertSame(estadoMock, energia.atualizarSinEnergia(estadoMock));
    }

    @Test
    public void testAtualizarConEnergiaNoCambiaEstado() {
        // Arrange
        Energia energia = new Energia();
        Estado estadoMock = mock(Estado.class);

        //Act
        energia.modificarPuntos(-20);

        //Assert
        assertSame(estadoMock, energia.atualizarConEnergia(estadoMock));
    }
}


