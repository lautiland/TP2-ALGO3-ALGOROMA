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
        Gladiador pepeMock = mock(Gladiador.class);

        // Act
        bacanal.interactuarCon(pepeMock);

        // Assert
        verify(pepeMock, times(1)).modificarEnergia(anyInt());
    }

    @Test
    public void test02GladiadorPateaUnaPiedraYSeLesiona() {
        // Arrange
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Gladiador pepeMock = mock(Gladiador.class);

        // Act
        lesion.interactuarCon(pepeMock);

        // Assert
        verify(pepeMock, times(1)).lesionar();

    }

}
