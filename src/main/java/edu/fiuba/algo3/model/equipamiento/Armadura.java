package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Armadura extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " tiene una armadura, pierde 10 puntos de energia");
        gladiador.modificarEnergia(-10);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe un escudo y una espada");
        return new EscudoYEspada();
    }
}
