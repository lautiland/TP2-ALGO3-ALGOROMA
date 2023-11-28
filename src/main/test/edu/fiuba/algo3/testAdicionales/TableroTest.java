package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.JSONReader;
import edu.fiuba.algo3.modelo.excepciones.Eliminado;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TableroTest {

    @Test
    public void test01UnJugadorEnTableroJuegaConMapaBacanalYQuedaEliminadoPorTomarseTodoElVino() throws IOException {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador pepe = new Gladiador("Pepe");
        gladiadores.add(pepe);
        DataClassTablero mapa = JSONReader.obtenerMapaDesdeJson("mapaBacanal.json");
        assert mapa != null;

        Tablero tablero = new Tablero(gladiadores, mapa);

        for (int i = 0; i < 14; i++) {
            pepe.modificarEnergia(100);// para que no pierda energia por los tragos
            tablero.turnoDe(pepe);
        }


        assertThrows(Eliminado.class, () -> tablero.turnoDe(pepe));
    }
}
