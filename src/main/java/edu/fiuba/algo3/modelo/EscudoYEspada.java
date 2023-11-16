package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EscudoYEspada implements Equipamiento{

    @Override
    public void resistir(Energia e) {
        e.restarPuntos(2);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Llave();
    }

}
