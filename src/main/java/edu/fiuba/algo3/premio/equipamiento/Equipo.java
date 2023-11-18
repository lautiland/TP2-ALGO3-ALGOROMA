package edu.fiuba.algo3.premio.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public abstract class Equipo {

    public abstract void resistirAtaque(Energia e);

    public abstract Equipo actualizar();


    public boolean equals(Equipo e) {
        return this.getClass() == e.getClass();
    }

}
