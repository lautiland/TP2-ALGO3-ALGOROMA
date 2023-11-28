package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.DataClassCelda;
import edu.fiuba.algo3.modelo.DataClassTablero;
import edu.fiuba.algo3.modelo.JsonReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SegundaEntregaTest {

    @Test
    void test16lecturaYConversionCorrectaAlModeloDeDominioDelProblema() throws IOException {
        //Arrange
        DataClassTablero dataTablero = JsonReader.obtenerMapaDesdeJson("mapa.json");
        assert dataTablero != null;

        //Act
        DataClassCelda dataCelda = dataTablero.camino.get(1);

        //Assert
        assertEquals("Equipamiento", dataCelda.premio);
    }
}
