package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.tablero.Camino;

public abstract class Equipamiento {

    public abstract void resistirAtaque(Gladiador gladiador);

    public abstract Equipamiento actualizar();

    public boolean abrirPuerta(Gladiador gladiador, Camino camino) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " no tiene llave, vuelve a mitad de camino");
        camino.moverAMitad(gladiador);
        return false;
    }
}
