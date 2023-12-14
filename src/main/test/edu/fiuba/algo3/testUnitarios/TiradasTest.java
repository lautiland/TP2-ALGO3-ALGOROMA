package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Tiradas;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Camino;
import edu.fiuba.algo3.model.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TiradasTest {
    private static final int TOTAL_TIRADAS_MENOS_UNO = 29;

    @Test
    public void test01NoSeHaceMasTiradasSiSeLlegaAlLimite() {
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        Tiradas tiradas = new Tiradas(dadoMock);

        for (int i = 0; i < TOTAL_TIRADAS_MENOS_UNO; i++) {
            tiradas.tirarDado();
        }

        assertEquals(1, tiradas.tirarDado());
        assertEquals(0, tiradas.tirarDado());
    }

    @Test
    public void test02SiSeLlegaAlLimiteElGladiadorNoSigueJugando() {
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        Tiradas tiradas = new Tiradas(dadoMock);
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable sinInteractuable = InteractuableFactory.crearInteractuable("Ninguno");
        camino.agregarCasilla(new Casilla(sinInteractuable, sinInteractuable));

        for (int i = 0; i < TOTAL_TIRADAS_MENOS_UNO + 1; i++) {
            tiradas.tirarDado();
        }

        assertTrue(camino.estaEl(gladiador, 0));

        tiradas.verificarLimite(gladiador, camino);

        assertFalse(camino.estaEl(gladiador, 0));
    }
}
