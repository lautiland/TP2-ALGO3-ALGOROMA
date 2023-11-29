package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tiradas;
import edu.fiuba.algo3.modelo.excepciones.Eliminado;
import edu.fiuba.algo3.modelo.excepciones.Ganador;
import edu.fiuba.algo3.modelo.interactuable.Ninguno;
import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExepcionesTest {

    @Test
    public void test01CuandoAlquienGanaSeLanzaUnaExecepcion() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador pepe = new Gladiador("Pepe", new Dado());
        for (int i = 1; i < 5; i++)
            pepe.actualizarEquipo();
        gladiadores.add(pepe);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act y Assert gladiador se mueve hasta el fin, gana porque tiene llave
        assertThrows(Ganador.class, () -> camino.mover(pepe, 50));
    }

    @Test
    public void test02CuandoUnJugadorSePasaDelLimiteDeTiradasSeLanzaUnaExcepcion() {
        Tiradas tiradas = new Tiradas(new Dado());
        Gladiador pepe = new Gladiador("Pepe", new Dado());
        for (int i = 0; i < 31; i++) {
            tiradas.tirarDado();
        }

        // Verificar que la excepción se lanza en la ejecución 30
        assertThrows(Eliminado.class, () -> tiradas.verificarLimite(pepe));
    }
}
