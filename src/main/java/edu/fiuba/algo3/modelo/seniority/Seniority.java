package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Seniority {

    protected int experiencia;

    public abstract Seniority actualizar(Gladiador g);

    public boolean equals(Seniority n) {
        return this.getClass() == n.getClass();
    }

}
