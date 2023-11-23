package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Equipo {

    public abstract void resistirAtaque(Gladiador g);

    public abstract Equipo actualizar();


    public boolean equals(Equipo e) {
        return this.getClass() == e.getClass();
    }

}
