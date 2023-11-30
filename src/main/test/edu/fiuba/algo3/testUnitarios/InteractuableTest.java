package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InteractuableTest {

    @Test
    public void test01GladiadorCaeEnBacanalYModificaSuEnergia() {
        // Arrange
        Interactuable bacanal = InteractuableFactory.crearInteractuable("Bacanal");
        Gladiador gladiadorMock = mock(Gladiador.class);

        // Act
        bacanal.interactuarCon(gladiadorMock);

        // Assert
        verify(gladiadorMock, times(1)).modificarEnergia(anyInt());
    }

    @Test
    public void test02GladiadorPateaUnaPiedraYSeLesiona() {
        // Arrange
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Gladiador gladiadorMock = mock(Gladiador.class);

        // Act
        lesion.interactuarCon(gladiadorMock);

        // Assert
        verify(gladiadorMock, times(1)).lesionar();

    }

}
