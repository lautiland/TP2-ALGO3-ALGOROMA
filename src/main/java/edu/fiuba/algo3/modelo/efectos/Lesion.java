package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.estado.Lesionado;

public class Lesion implements Efecto {
    @Override
    public void aplicar(Gladiador g) {
        g.setEstado(new Lesionado());
    }
}
