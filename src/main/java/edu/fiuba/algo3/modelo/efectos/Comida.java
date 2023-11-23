package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Gladiador;

public class Comida implements Efecto {

    @Override
    public void aplicar(Gladiador g) {
        g.comer(10);
    }
}
