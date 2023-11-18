package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Gladiador;

public class Lesion implements Efecto {
    @Override
    public void aplicar(Gladiador g) {
        g.lesion();
    }
}
