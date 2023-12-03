package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;

public class SinEquipamiento extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador" + gladiador.getNombre() + " no tiene equipamiento, pierde 20 puntos de energia");
        gladiador.modificarEnergia(-20);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe casco");
        return new Casco();
    }
}
