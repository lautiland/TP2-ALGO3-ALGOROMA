package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.excepciones.JSONInvalido;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import edu.fiuba.algo3.model.parser.JSONReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class JSONReaderTest {
    private static final int INDICE_CAMINO_LESION_COMIDA = 26;

    private static final int MAPA_ANCHO = 11;
    private static final int MAPA_LARGO = 19;
    private static final int MAPA_CANTIDAD_CELDAS = 38;
    private static final String SIN_INTERACTUABLE = "";
    private static final int PRIMER_CELDA_X = 1;
    private static final int PRIMER_CELDA_Y = 7;
    private static final int ULTIMA_CELDA_X = 17;
    private static final int ULTIMA_CELDA_Y = 1;
    private static final int CELDA_RANDOM_X = 13;
    private static final int CELDA_RANDOM_Y = 9;
    private static final String CELDA_RANDOM_OBSTACULO = "Lesion";
    private static final String CELDA_RANDOM_PREMIO = "Comida";

    private static final String mapaValido = "mapa.json";
    private static final String mapaInvalido = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/mapaInvalido.json";
    private static final String mapaCeldaInvalida = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/mapaCeldaInvalida.json";
    private static final String mapaSinX = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinX.json";
    private static final String mapaSinCamino = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinCamino.json";
    private static final String mapaSinCeldas = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinCeldas.json";
    private static final String sinMapa = "src/main/test/edu/fiuba/algo3/testUnitarios/examples/sinMapa.json";

    @Test
    public void test01SeCreaUnMapaConJSONValido() throws FileNotFoundException {
        Reader reader = new FileReader(mapaValido);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson(reader);
        DataClassCelda primerCelda = mapa.camino.get(0);
        DataClassCelda celdaRandom = mapa.camino.get(INDICE_CAMINO_LESION_COMIDA);
        DataClassCelda ultimaCelda = mapa.camino.get(mapa.camino.size() - 1);
        assertNotNull(mapa);

        assertEquals(MAPA_ANCHO, mapa.ANCHO);
        assertEquals(MAPA_LARGO, mapa.LARGO);
        assertEquals(MAPA_CANTIDAD_CELDAS, mapa.camino.size() - 1);

        assertEquals(PRIMER_CELDA_X, primerCelda.X);
        assertEquals(PRIMER_CELDA_Y, primerCelda.Y);
        assertEquals(SIN_INTERACTUABLE, primerCelda.obstaculo);
        assertEquals(SIN_INTERACTUABLE, primerCelda.premio);

        assertEquals(ULTIMA_CELDA_X, ultimaCelda.X);
        assertEquals(ULTIMA_CELDA_Y, ultimaCelda.Y);
        assertEquals(SIN_INTERACTUABLE, ultimaCelda.obstaculo);
        assertEquals(SIN_INTERACTUABLE, ultimaCelda.premio);

        assertEquals(CELDA_RANDOM_X, celdaRandom.X);
        assertEquals(CELDA_RANDOM_Y, celdaRandom.Y);
        assertEquals(CELDA_RANDOM_OBSTACULO, celdaRandom.obstaculo);
        assertEquals(CELDA_RANDOM_PREMIO, celdaRandom.premio);
    }

    @Test
    public void test02SeIntentaCrearUnMapaConJSONInvalido() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(mapaInvalido);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }

    @Test
    public void test03SeintentaCrearUnMapaConCeldaSinY() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(mapaCeldaInvalida);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }

    @Test
    public void test04SeIntentaCrearUnMapaConCeldaSinX() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(mapaSinX);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }

    @Test
    public void test05SeIntentaCrearUnMapaSinCamino() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(mapaSinCamino);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }

    @Test
    public void test06SeIntentaCrearUnMapaSinCeldas() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(mapaSinCeldas);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }

    @Test
    public void test07SeIntentaCrearUnMapaSinMapa() {
        assertThrows(JSONInvalido.class, () -> {
            Reader reader = new FileReader(sinMapa);
            JSONReader.obtenerMapaDesdeJson(reader);
        });
    }
}
