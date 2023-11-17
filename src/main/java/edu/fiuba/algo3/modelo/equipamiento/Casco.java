package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;

public class Casco extends Equipamiento {

    @Override
    public void resistirAtaque(Energia e) {
        e.restarPuntos(15);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Armadura();
    }

}
