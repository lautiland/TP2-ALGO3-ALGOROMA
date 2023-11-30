package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class SinEquipamiento extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        System.out.print(", perdes 20 puntos de energia");
        gladiador.modificarEnergia(-20);
    }

    @Override
    public Equipamiento actualizar() {
        System.out.print(", recibiste casco");
        return new Casco();
    }
}