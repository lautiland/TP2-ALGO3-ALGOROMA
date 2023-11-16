package edu.fiuba.algo3.PatronDeDisenio;

import edu.fiuba.algo3.modelo.Gladiador;
import org.junit.jupiter.api.Test;

public class PatronStateNivelTest {


    @Test
    public void gladiadorNovatoSubeDeNivel() {
        //Act
        Gladiador gladiador = new Gladiador();
        for (int turno=1; turno < 13; turno++) {
            gladiador.jugar();
        }

    }
}
