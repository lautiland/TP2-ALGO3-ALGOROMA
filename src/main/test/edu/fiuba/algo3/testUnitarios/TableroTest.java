package edu.fiuba.algo3.testUnitarios;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TableroTest {

    @Test
    public void test01UnJugadorEnTableroJuegaConMapaBacanalYQuedaEliminadoPorTomarseTodoElVino() throws IOException {
       /* Los jugadores no se eliminan por tomar vino, si se quedan sin turnos termina el juego.
       Nota: una vez se terminan los turnos NINGUN jugador sigue jugando por lo cual nunca se "elimina" a alguien simplemente se queda infinitamente sin avanzar si no tiene energia.
       //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Marcus", new Dado());
        gladiadores.add(gladiador);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson("mapaBacanal.json");

        Tablero tablero = new Tablero(gladiadores, mapa);

        for (int i = 0; i < 14; i++) {
            gladiador.modificarEnergia(100);// para que no pierda energia por los tragos
            tablero.turnoDe(gladiador);
        }


        assertThrows(Eliminado.class, () -> tablero.turnoDe(gladiador));*/
    }
}
