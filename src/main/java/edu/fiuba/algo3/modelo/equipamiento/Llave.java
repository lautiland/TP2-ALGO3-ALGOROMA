package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Llave extends Equipamiento {
    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " tiene la llave, no pierde energia");
        gladiador.modificarEnergia(0);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador cayo en una casilla de mejora pero ya esta al máximo");
        return this;
    }

    @Override
    public boolean abrirPuerta(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " abrió la puerta con la llave");
        return true;
    }

}
