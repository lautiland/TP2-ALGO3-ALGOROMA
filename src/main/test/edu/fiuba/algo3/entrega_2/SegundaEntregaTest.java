package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.parser.DataClassCelda;
import edu.fiuba.algo3.modelo.parser.DataClassTablero;
import edu.fiuba.algo3.modelo.parser.JuegoParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegundaEntregaTest {

    @Test
    public void test13ElJSONDelMapaEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(10, DataTablero.ANCHO);
        assertEquals(18, DataTablero.LARGO);
    }

    @Test
    public void test14ElJSONDeLosObstaculosEsValido() throws IOException {
        JuegoParser juegoParser = new JuegoParser();
        DataClassTablero DataTablero = juegoParser.parsear("mapa.json", "json");
        assertEquals(38, DataTablero.getCamino().size());

        DataClassCelda primerCelda = DataTablero.getCamino().get(0);
        DataClassCelda ultimaCelda = DataTablero.getLlegada();
        DataClassCelda celdaConDosObstaculos = DataTablero.getCamino().get(26);

        assertEquals(1, primerCelda.X);
        assertEquals(7, primerCelda.Y);
        assertEquals("", primerCelda.obstaculo);
        assertEquals("", primerCelda.premio);

        assertEquals(17, ultimaCelda.X);
        assertEquals(1, ultimaCelda.Y);
        assertEquals("", ultimaCelda.obstaculo);
        assertEquals("", ultimaCelda.premio);

        assertEquals(13, celdaConDosObstaculos.X);
        assertEquals(9, celdaConDosObstaculos.Y);
        assertEquals("Lesion", celdaConDosObstaculos.obstaculo);
        assertEquals("Comida", celdaConDosObstaculos.premio);
    }

    @Test
    public void test17ElJuegoSeCreaAcordeAlJSON() {
    }
}


