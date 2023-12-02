package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.tablero.Camino;

public abstract class Equipamiento {

    public abstract void resistirAtaque(Gladiador gladiador);

    public abstract Equipamiento actualizar();

    public boolean abrirPuerta(Gladiador gladiador, Camino camino) {
        System.out.print(gladiador.NOMBRE + " no tiene llave, vuelve a mitad de camino");
        camino.moverAMitad(gladiador);
        return false;
    }
}
