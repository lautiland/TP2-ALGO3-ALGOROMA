package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;
import edu.fiuba.algo3.modelo.parser.JuegoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JSONReaderTest {

    private JuegoParser juegoParser;

    @BeforeEach
    public void setUp() {
        juegoParser = new JuegoParser();
    }

    @Test
    public void test01SeIntentaCrearUnMapaConJSONInexistente() {
        assertThrows(IOException.class, () -> juegoParser.parsear("mapaInexistente.json", "json"));
    }

    @Test
    public void test02SeIntentaCrearUnMapaConJSONInvalido() {
        assertThrows(JSONInvalido.class, () -> juegoParser.parsear("src/main/test/edu/fiuba/algo3/testUnitarios/mapaInvalido.json", "json"));
    }

    @Test
    public void test03SeintentaCrearUnMapaConCeldaSinY() {
        assertThrows(JSONInvalido.class, () -> juegoParser.parsear("src/main/test/edu/fiuba/algo3/testUnitarios/mapaCeldaInvalida.json", "json"));
    }
}
