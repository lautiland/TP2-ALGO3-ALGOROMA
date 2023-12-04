package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.parser.JuegoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JuegoParserTest {
    private Logger loggerMock;

    @BeforeEach
    public void setUp() {
        loggerMock = mock(Logger.class);
        new Logger(loggerMock);
    }

    @Test
    public void test01NoPuedoParsearArchivoCorrectoConFormatoInvalido() throws IOException {
        JuegoParser parser = new JuegoParser();
        assertNull(parser.parsear("mapa.json", "xml"));
        verify(loggerMock).error("Formato no soportado: xml");
    }

    @Test
    public void test02NoPuedoParsearArchivoInexistente() {
        JuegoParser parser = new JuegoParser();
        assertThrows(IOException.class, () -> parser.parsear("src/main/test/edu/fiuba/algo3/testUnitarios/examples/inexistente.json", "json"));
        verify(loggerMock).error(anyString());
    }

    @Test
    public void test03NoPuedoParsearArchivoConFormatoValido() throws IOException {
        JuegoParser parser = new JuegoParser();
        assertNotNull(parser.parsear("mapa.json", "json"));
    }
}
