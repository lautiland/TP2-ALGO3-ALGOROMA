package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public abstract class Equipamiento {

    public abstract void resistirAtaque(Energia e);

    public abstract Equipamiento actualizarEquipo();


    public boolean equals(Equipamiento e) {
        return this.getClass() == e.getClass();
    }

}
