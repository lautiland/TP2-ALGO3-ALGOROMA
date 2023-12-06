package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Casco extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " tiene un casco, pierde 15 puntos de energia");
        gladiador.modificarEnergia(-15);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe una armadura");
        return new Armadura();
    }

}
