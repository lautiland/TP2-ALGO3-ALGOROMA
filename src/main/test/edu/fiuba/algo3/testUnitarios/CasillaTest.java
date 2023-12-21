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
        Interactuable lesion = InteractuableFactory.crearInteractuable("lesion");
        Interactuable comida = InteractuableFactory.crearInteractuable("comida");

        Casilla casilla = new Casilla(comida, lesion);
        CeldaSinCasilla celdaVacia = new CeldaSinCasilla();

        assertEquals("comida", casilla.nombrePremio());
        assertEquals("lesion", casilla.nombreObstaculo());

        assertEquals("sininteraccion", celdaVacia.nombrePremio());
        assertEquals("sininteraccion", celdaVacia.nombreObstaculo());
    }

    @Test
    public void test02PuedoDistinguirEntreUnaCeldaVaciaYUnaConCasilla() {
        Interactuable lesion = InteractuableFactory.crearInteractuable("lesion");
        Interactuable comida = InteractuableFactory.crearInteractuable("comida");
        Celda celdaVacia = new CeldaSinCasilla();
        Celda celdaConCasilla = new Casilla(comida, lesion);

        assertTrue(celdaVacia.equals("sininteraccion"));
        assertFalse(celdaConCasilla.equals("sininteraccion"));
    }
}
