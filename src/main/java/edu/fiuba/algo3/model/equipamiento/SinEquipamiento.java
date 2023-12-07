package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class SinEquipamiento extends Equipamiento {

    private static final int DANIO_PUNTOS = -20;

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador" + gladiador.getNombre() + " no tiene equipamiento, pierde 20 puntos de energia");
        gladiador.modificarEnergia(DANIO_PUNTOS);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe casco");
        return new Casco();
    }
}
