package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeniorityTest {

    @Test
    public void test01gladiadorNovatoSubeDeNivelHastaSenior() {
        // Arramge
        Gladiador gladiador = new Gladiador("Pepe", new Dado());

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.actualizarSeniority();
        }
        //sube a semisenior, empieza a sumar de a 5

        for (int turno = 9; turno <= 12; turno++) {
            gladiador.actualizarSeniority();
        }
        //sube a senior, empieza a sumar de a 10
        gladiador.actualizarSeniority();

        //Assert, en total suma 30 puntos, mas los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(50));
    }
}
