package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeniorityTest {

    private static final int TURNOS_PARA_SENIOR = 12;
    private static final int TURNOS_PARA_SEMISENIOR = 8;
    private static final int PUNTOS_FINALES_CON_12_TURNOS = 50;

    @Test
    public void test01gladiadorNovatoSubeDeNivelHastaSenior() {
        // Arramge
        Gladiador gladiador = new Gladiador("Marcus", new Dado());

        // Act
        for (int turno = 1; turno < TURNOS_PARA_SEMISENIOR; turno++) {
            gladiador.actualizarSeniority();
        }
        //sube a semisenior, empieza a sumar de a 5

        for (int turno = 9; turno < TURNOS_PARA_SENIOR; turno++) {
            gladiador.actualizarSeniority();
        }
        //sube a senior, empieza a sumar de a 10
        gladiador.actualizarSeniority();

        //Assert, en total suma 30 puntos, mas los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(PUNTOS_FINALES_CON_12_TURNOS));
    }
}
