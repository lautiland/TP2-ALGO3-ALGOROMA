package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Camino;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InteractuableTest {

    @Test
    public void test01GladiadorCaeEnBacanalYModificaSuEnergia() {
        // Arrange
        Interactuable bacanal = InteractuableFactory.crearInteractuable("Bacanal");
        Gladiador gladiadorMock = mock(Gladiador.class);
        Camino caminoMock = mock(Camino.class);

        // Act
        bacanal.interactuarCon(gladiadorMock, caminoMock);

        // Assert
        verify(gladiadorMock, times(1)).modificarEnergia(anyInt());
    }

    @Test
    public void test02GladiadorPateaUnaPiedraYSeLesiona() {
        // Arrange
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Gladiador gladiadorMock = mock(Gladiador.class);
        Camino caminoMock = mock(Camino.class);

        // Act
        lesion.interactuarCon(gladiadorMock, caminoMock);

        // Assert
        verify(gladiadorMock, times(1)).lesionar();

    }

}
