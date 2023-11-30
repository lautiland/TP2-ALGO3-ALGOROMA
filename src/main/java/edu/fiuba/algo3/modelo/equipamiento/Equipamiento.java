package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Equipamiento {

    public abstract void resistirAtaque(Gladiador gladiador);

    public abstract Equipamiento actualizar();

    public void abrirPuerta(Gladiador gladiador, Camino camino) {
        System.out.print(gladiador.NOMBRE + " no tiene llave, vuelve a mitad de camino");
        camino.moverAMitad(gladiador);
    }

    public boolean equals(Equipamiento equipamiento) {
        return this.getClass() == equipamiento.getClass();
    }
}
