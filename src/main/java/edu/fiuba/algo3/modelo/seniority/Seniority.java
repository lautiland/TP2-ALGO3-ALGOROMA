package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Seniority {

    protected int experiencia;

    public abstract Seniority actualizar(Gladiador gladiador);

    public boolean equals(Seniority seniority) {
        return this.getClass() == seniority.getClass();
    }

}
