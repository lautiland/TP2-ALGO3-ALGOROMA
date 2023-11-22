package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.TableroB;

public class Lesionado implements Estado {
    @Override
    public Estado jugar(Gladiador g, TableroB t) {
        return new Lesionado();
    }
}
