package edu.fiuba.algo3.model.seniority;

import edu.fiuba.algo3.model.Gladiador;

public abstract class Seniority {

    protected int experiencia;

    public abstract Seniority actualizar(Gladiador gladiador);
}
