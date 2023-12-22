package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.tablero.Camino;

public abstract class Equipamiento {

    public abstract void resistirAtaque(Gladiador gladiador);

    public abstract Equipamiento actualizar();

    public boolean abrirPuerta(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no tiene llave, vuelve a mitad de camino");
        camino.moverAMitad(gladiador);
        return false;
    }

    @Override
    public String toString() {
        return "sinequipamiento";
    }
}
