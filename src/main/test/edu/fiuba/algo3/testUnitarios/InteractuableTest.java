package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Camino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void test03SePuedenConvertirAStringCorrectamente() {
        Interactuable ninguno = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Interactuable bacanal = InteractuableFactory.crearInteractuable("Bacanal");
        Interactuable comida = InteractuableFactory.crearInteractuable("Comida");
        Interactuable equipamiento = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable llegada = InteractuableFactory.crearInteractuable("Llegada");
        Interactuable Fiera = InteractuableFactory.crearInteractuable("Fiera");

        assertEquals("Vacio", ninguno.toString());
        assertEquals("Lesion", lesion.toString());
        assertEquals("Bacanal", bacanal.toString());
        assertEquals("Comida", comida.toString());
        assertEquals("Equipamiento", equipamiento.toString());
        assertEquals("Llegada", llegada.toString());
        assertEquals("Fiera", Fiera.toString());
    }
}
