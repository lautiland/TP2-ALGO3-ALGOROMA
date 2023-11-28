package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Lesionado;
import edu.fiuba.algo3.modelo.estado.Sano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstadoTest {

    @Test
    public void test01DeLesionadoSePasaASano() {
        //Act
        Gladiador pepe = new Gladiador("Pepe");
        Estado lesionado = new Lesionado();

        //Arrange
        Estado nuevoEstado = lesionado.jugar(pepe);

        //Assert
        assertTrue(nuevoEstado instanceof Sano);




    }
}
