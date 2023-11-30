package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class Casco extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        System.out.print(", perdes 15 puntos de energia");
        gladiador.modificarEnergia(-15);
    }

    @Override
    public Equipamiento actualizar() {
        System.out.print(", recibiste armadura");
        return new Armadura();
    }

}
