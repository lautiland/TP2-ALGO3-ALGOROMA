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
        Interactuable bacanal = InteractuableFactory.crearInteractuable("bacanal");
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
        Interactuable lesion = InteractuableFactory.crearInteractuable("lesion");
        Gladiador gladiadorMock = mock(Gladiador.class);
        Camino caminoMock = mock(Camino.class);

        // Act
        lesion.interactuarCon(gladiadorMock, caminoMock);

        // Assert
        verify(gladiadorMock, times(1)).lesionar();
    }

    @Test
    public void test03SePuedenConvertirAStringCorrectamente() {
        Interactuable sinInteraccion = InteractuableFactory.crearInteractuable("sininteraccion");
        Interactuable lesion = InteractuableFactory.crearInteractuable("lesion");
        Interactuable bacanal = InteractuableFactory.crearInteractuable("bacanal");
        Interactuable comida = InteractuableFactory.crearInteractuable("comida");
        Interactuable equipamiento = InteractuableFactory.crearInteractuable("equipamiento");
        Interactuable llegada = InteractuableFactory.crearInteractuable("llegada");
        Interactuable Fiera = InteractuableFactory.crearInteractuable("fiera");

        assertEquals("sininteraccion", sinInteraccion.toString());
        assertEquals("lesion", lesion.toString());
        assertEquals("bacanal", bacanal.toString());
        assertEquals("comida", comida.toString());
        assertEquals("equipamiento", equipamiento.toString());
        assertEquals("llegada", llegada.toString());
        assertEquals("fiera", Fiera.toString());
    }
}
