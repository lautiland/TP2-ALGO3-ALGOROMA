package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.JSONReader;
import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JSONReaderTest {

    @Test
    public void test01SeIntentaCrearUnMapaConJSONInexistente() {
        assertThrows(IOException.class, () -> JSONReader.obtenerMapaDesdeJson("mapaInexistente.json"));
    }

    @Test
    public void test02SeIntentaCrearUnMapaConJSONInvalido() {
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson("src/main/test/edu/fiuba/algo3/testUnitarios/mapaInvalido.json"));
    }

    @Test
    public void test03SeintentaCrearUnMapaConCeldaSinY() {
        assertThrows(JSONInvalido.class, () -> JSONReader.obtenerMapaDesdeJson("src/main/test/edu/fiuba/algo3/testUnitarios/mapaCeldaInvalida.json"));
    }
}
