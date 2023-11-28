package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.interactuable.*;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        verify(pepeMock, times(1)).esLesionado();
    }

    @Test
    public void test03GladiadorPeleaConFieraYModificaSuEnegia() {
        // Arrange
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");
        Gladiador pepeMock = mock(Gladiador.class);

        // Act
        fiera.interactuarCon(pepeMock);

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
