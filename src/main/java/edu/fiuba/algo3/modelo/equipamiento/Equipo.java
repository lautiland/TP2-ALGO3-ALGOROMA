package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Equipo {

    public abstract void resistirAtaque(Gladiador gladiador);

    public abstract Equipo actualizar();

    public void abrirPuerta(Gladiador gladiador, Camino camino) {
        System.out.print(gladiador.nombre + " no tiene llave, vuelve a mitad de camino");
        camino.moverAMitad(gladiador);
    }

    public boolean equals(Equipo equipo) {
        return this.getClass() == equipo.getClass();
    }
}
