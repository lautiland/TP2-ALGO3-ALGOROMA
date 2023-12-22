package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Camino;
import edu.fiuba.algo3.model.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CaminoTest {
    @Test
    public void test01SiIntentoPasarmeDeLaUltimaCasillaNoPuedo() {
        Dado dadoMock = mock(Dado.class);

        Interactuable vacio = InteractuableFactory.crearInteractuable("Ninguno");

        Gladiador gladiador = new Gladiador("Gladiador", dadoMock);
        Camino camino = new Camino(List.of(gladiador));

        camino.agregarCasilla(new Casilla(vacio, vacio));
        camino.agregarCasilla(new Casilla(vacio, vacio));
        camino.agregarCasilla(new Casilla(vacio, vacio));

        camino.mover(gladiador, 1);
        assertTrue(camino.estaEl(gladiador, 1));

        camino.mover(gladiador, 2); // Se sale del mapa
        assertTrue(camino.estaEl(gladiador, 2));
    }

    @Test
    public void test02PuedoEliminarUnGladiadorCorrectamenteDelCamino() {
        Dado dadoMock = mock(Dado.class);

        Interactuable vacio = InteractuableFactory.crearInteractuable("Ninguno");

        Gladiador gladiador = new Gladiador("Gladiador", dadoMock);
        Camino camino = new Camino(List.of(gladiador));

        camino.agregarCasilla(new Casilla(vacio, vacio));
        camino.agregarCasilla(new Casilla(vacio, vacio));
        camino.agregarCasilla(new Casilla(vacio, vacio));

        camino.mover(gladiador, 2);
        assertTrue(camino.estaEl(gladiador, 2));

        camino.eliminarGladiadorDeCamino(gladiador);
        assertFalse(camino.estaEl(gladiador, 2));
    }

    @Test
    public void test03PuedoObtenerElGanadorCorrectamente() {
        Dado dadoMock = mock(Dado.class);

        Interactuable vacio = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable equipamiento = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable meta = InteractuableFactory.crearInteractuable("Llegada");

        Gladiador gladiador = new Gladiador("Gladiador", dadoMock);
        Camino camino = new Camino(List.of(gladiador));

        camino.agregarCasilla(new Casilla(vacio, vacio));
        camino.agregarCasilla(new Casilla(equipamiento, vacio));
        camino.agregarCasilla(new Casilla(equipamiento, vacio));
        camino.agregarCasilla(new Casilla(equipamiento, vacio));
        camino.agregarCasilla(new Casilla(equipamiento, vacio));
        camino.agregarCasilla(new Casilla(vacio, meta));

        camino.mover(gladiador, 1);
        camino.mover(gladiador, 1);
        camino.mover(gladiador, 1);
        camino.mover(gladiador, 1);

        camino.mover(gladiador, 2);
        assertTrue(camino.tieneGanador());
        assertEquals(gladiador, camino.obtenerGanador());
    }
}
