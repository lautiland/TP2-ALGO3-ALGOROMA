package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepciones.Ganador;

public abstract class Equipo {

    public abstract void resistirAtaque(Gladiador g);

    public abstract Equipo actualizar();

    public void abrirPuerta(Gladiador g, Camino c) {
        System.out.print(g.nombre + " no tiene llave, vuelve a mitad de camino");
        c.moverAMitad(g);
    }

    public boolean equals(Equipo e) {
        return this.getClass() == e.getClass();
    }
}
