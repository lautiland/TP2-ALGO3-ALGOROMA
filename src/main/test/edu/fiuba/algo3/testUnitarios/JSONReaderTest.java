package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;
import edu.fiuba.algo3.modelo.parser.DataClassCelda;
import edu.fiuba.algo3.modelo.parser.DataClassTablero;
import edu.fiuba.algo3.modelo.parser.JSONReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class JSONReaderTest {
    private final String mapaValido = "mapa.json";
    private final String mapaInvalido = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/mapaInvalido.json";
    private final String mapaCeldaInvalida = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/mapaCeldaInvalida.json";
    private final String mapaSinX = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinX.json";
    private final String mapaSinCamino = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinCamino.json";
    private final String mapaSinCeldas = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinCeldas.json";
    private final String sinMapa = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinMapa.json";

    @Test
    public void test01SeCreaUnMapaConJSONValido() throws FileNotFoundException {
        Reader reader = new FileReader(mapaValido);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson(reader);
        DataClassCelda primerCelda = mapa.camino.get(0);
        DataClassCelda celdaRandom = mapa.camino.get(26);
        DataClassCelda ultimaCelda = mapa.camino.get(mapa.camino.size() - 1);
        assertNotNull(mapa);

        assertEquals(10, mapa.ANCHO);
        assertEquals(18, mapa.LARGO);
        assertEquals(38, mapa.camino.size() - 1);

        assertEquals(1, primerCelda.X);
        assertEquals(7, primerCelda.Y);
        assertEquals("", primerCelda.obstaculo);
        assertEquals("", primerCelda.premio);

        assertEquals(17, ultimaCelda.X);
        assertEquals(1, ultimaCelda.Y);
        assertEquals("", ultimaCelda.obstaculo);
        assertEquals("", ultimaCelda.premio);

        assertEquals(13, celdaRandom.X);
        assertEquals(9, celdaRandom.Y);
        assertEquals("Lesion", celdaRandom.obstaculo);
        assertEquals("Comida", celdaRandom.premio);
    }

    @Test
    public void test02SeIntentaCrearUnMapaConJSONInvalido() throws FileNotFoundException {
        Reader reader = new FileReader(mapaInvalido);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }

    @Test
    public void test03SeintentaCrearUnMapaConCeldaSinY() throws FileNotFoundException {
        Reader reader = new FileReader(mapaCeldaInvalida);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }

    @Test
    public void test04SeIntentaCrearUnMapaConCeldaSinX() throws FileNotFoundException {
        Reader reader = new FileReader(mapaSinX);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }

    @Test
    public void test05SeIntentaCrearUnMapaSinCamino() throws FileNotFoundException {
        Reader reader = new FileReader(mapaSinCamino);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }

    @Test
    public void test06SeIntentaCrearUnMapaSinCeldas() throws FileNotFoundException {
        Reader reader = new FileReader(mapaSinCeldas);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }

    @Test
    public void test07SeIntentaCrearUnMapaSinMapa() throws FileNotFoundException {
        Reader reader = new FileReader(sinMapa);
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson(reader));
    }
}
