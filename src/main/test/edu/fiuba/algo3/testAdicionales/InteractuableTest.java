package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;
import edu.fiuba.algo3.modelo.interactuable.Ninguno;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InteractuableTest {

    @Test
    public void test01GladiadorCaeEnCasillaConBacanalYModificaSuEnergia() {
        // Arrange
        Interactuable bacanal = InteractuableFactory.crearInteractuable("Bacanal");
        Gladiador pepeMock = mock(Gladiador.class);
        Casilla casilla = new Casilla(new Ninguno(), bacanal);

        // Act
        casilla.interactuarCon(pepeMock);

        // Assert
        verify(pepeMock, times(1)).modificarEnergia(anyInt());
    }

    @Test
    public void test02GladiadorCaeEnCasillaYSeLesiona() {
        // Arrange
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Gladiador pepeMock = mock(Gladiador.class);
        Casilla casilla = new Casilla(new Ninguno(), lesion);

        // Act
        casilla.interactuarCon(pepeMock);

        // Assert
        verify(pepeMock, times(1)).esLesionado();
    }
}
