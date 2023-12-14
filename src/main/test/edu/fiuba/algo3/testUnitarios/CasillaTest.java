package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Casilla;
import edu.fiuba.algo3.model.tablero.Celda;
import edu.fiuba.algo3.model.tablero.CeldaSinCasilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaTest {
    @Test
    public void test01PuedoObtenerLosNombresDePremiosYObstaculos() {
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Interactuable Comida = InteractuableFactory.crearInteractuable("Comida");

        Casilla casilla = new Casilla(Comida, lesion);
        CeldaSinCasilla celdaVacia = new CeldaSinCasilla();

        assertEquals("Comida", casilla.nombrePremio());
        assertEquals("Lesion", casilla.nombreObstaculo());

        assertEquals("vacio", celdaVacia.nombrePremio());
        assertEquals("vacio", celdaVacia.nombreObstaculo());
    }

    @Test
    public void test02PuedoDistinguirEntreUnaCeldaVaciaYUnaConCasilla() {
        Interactuable lesion = InteractuableFactory.crearInteractuable("Lesion");
        Interactuable Comida = InteractuableFactory.crearInteractuable("Comida");
        Celda celdaVacia = new CeldaSinCasilla();
        Celda celdaConCasilla = new Casilla(Comida, lesion);

        assertTrue(celdaVacia.equals("vacio"));
        assertFalse(celdaConCasilla.equals("vacio"));
    }
}
