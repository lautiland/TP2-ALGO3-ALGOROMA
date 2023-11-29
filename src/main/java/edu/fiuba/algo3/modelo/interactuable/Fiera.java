package edu.fiuba.algo3.modelo.interactuable;

import edu.fiuba.algo3.modelo.Gladiador;

public class Fiera implements Interactuable {

    @Override
    public void interactuarCon(Gladiador gladiador) {
        System.out.print(", caes en la jaula del leon");
        gladiador.esAtacado();
    }
}
