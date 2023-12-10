package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.parser.JuegoParser;
import edu.fiuba.algo3.model.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableroTest {
    @Test
    public void test01SeObtieneLaPosicionDeUnGladiador() throws IOException {
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Tablero tablero = new Tablero(List.of(gladiador), new JuegoParser().parsear("mapa.json", "json"));

        assertEquals(1, tablero.obtenerPosicionDe(gladiador).X);
        assertEquals(7, tablero.obtenerPosicionDe(gladiador).Y);

        tablero.turnoDe(gladiador);

        assertEquals(2, tablero.obtenerPosicionDe(gladiador).X);
        assertEquals(7, tablero.obtenerPosicionDe(gladiador).Y);

        when(dadoMock.tirar()).thenReturn(5);
        tablero.turnoDe(gladiador);

        assertEquals(2, tablero.obtenerPosicionDe(gladiador).X);
        assertEquals(2, tablero.obtenerPosicionDe(gladiador).Y);
    }
}
