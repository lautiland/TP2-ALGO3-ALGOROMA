package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.DataClassCelda;
import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.JSONReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegundaEntregaTest {

    @Test
    public void test13ElJSONDelMapaEsValido() throws IOException {
        DataClassTablero DataTablero = JSONReader.obtenerMapaDesdeJson("mapa.json");
        assertEquals(10, DataTablero.getANCHO());
        assertEquals(18, DataTablero.getLARGO());
    }

    @Test
    public void test14ElJSONDeLosObstaculosEsValido() throws IOException {
        DataClassTablero DataTablero = JSONReader.obtenerMapaDesdeJson("mapa.json");
        assertEquals(38, DataTablero.getCamino().size());

        DataClassCelda primerCelda = DataTablero.getCamino().get(0);
        DataClassCelda ultimaCelda = DataTablero.getLlegada();
        DataClassCelda celdaConDosObstaculos = DataTablero.getCamino().get(26);

        assertEquals(1, primerCelda.getX());
        assertEquals(7, primerCelda.getY());
        assertEquals("", primerCelda.getObstaculo());
        assertEquals("", primerCelda.getPremio());

        assertEquals(17, ultimaCelda.getX());
        assertEquals(1, ultimaCelda.getY());
        assertEquals("", ultimaCelda.getObstaculo());
        assertEquals("", ultimaCelda.getPremio());

        assertEquals(13, celdaConDosObstaculos.getX());
        assertEquals(9, celdaConDosObstaculos.getY());
        assertEquals("Lesion", celdaConDosObstaculos.getObstaculo());
        assertEquals("Comida", celdaConDosObstaculos.getPremio());
    }

    @Test
    public void test17ElJuegoSeCreaAcordeAlJSON() {
    }
}


