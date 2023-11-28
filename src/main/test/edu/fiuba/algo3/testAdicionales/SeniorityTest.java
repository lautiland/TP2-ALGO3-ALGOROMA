package edu.fiuba.algo3.testAdicionales;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeniorityTest {

    @Test
    public void test01gladiadorNovatoSubeDeNivelHastaSenior() {
        // Arramge
        Gladiador gladiador = new Gladiador("Pepe");
        Novato novato = new Novato();
        SemiSenior semiSenior = new SemiSenior(8);
        Senior senior = new Senior(12);

        //ver el nivel inicial
        assertTrue(gladiador.tenesElNivel(novato));

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.actualizarSeniority();
        }

        // Sube a semi senior
        assertTrue(gladiador.tenesElNivel(semiSenior));

        for (int turno = 9; turno <= 12; turno++) {
            gladiador.actualizarSeniority();
        }
        //Assert
        assertTrue(gladiador.tenesElNivel(senior));
    }
}
