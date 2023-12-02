package edu.fiuba.algo3.testUnitarios;

import org.junit.jupiter.api.Test;

public class ExepcionesTest {

    @Test
    public void test01CuandoAlquienGanaSeLanzaUnaExecepcion() {
        /* No se lanza una excepcion, excepciones solo en caso de errores
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Ignacius", new Dado());
        for (int i = 1; i < 5; i++)
            gladiador.actualizarEquipo();
        gladiadores.add(gladiador);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act y Assert gladiador se mueve hasta el fin, gana porque tiene llave
        assertThrows(Ganador.class, () -> camino.mover(gladiador, 50));*/
    }

    @Test
    public void test02CuandoUnJugadorSePasaDelLimiteDeTiradasSeLanzaUnaExcepcion() {
        /* Esto que funcion tiene? no hay limite de tiradas hay limite de turnos...
        Tiradas tiradas = new Tiradas(new Dado());
        Gladiador gladiador = new Gladiador("Ignacius", new Dado());
        Camino camino = new Camino(List.of(gladiador));
        for (int i = 0; i < 31; i++) {
            tiradas.tirarDado();
        }

        // Verificar que la excepción se lanza en la ejecución 30
        assertThrows(Eliminado.class, () -> tiradas.verificarLimite(gladiador, camino));*/
    }
}
