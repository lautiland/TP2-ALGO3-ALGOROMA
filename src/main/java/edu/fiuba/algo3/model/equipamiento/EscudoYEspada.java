package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class EscudoYEspada extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " tiene escudo y espada,pierde 2 puntos de energia");
        gladiador.modificarEnergia(-2);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe una llave");
        return new Llave();
    }

    @Override
    public String toString() {
        return "escudoyespada";
    }
}
