package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepciones.Ganador;

public class Llave extends Equipo {
    @Override
    public void resistirAtaque(Gladiador g) {
        System.out.print(", resististe todo el ataque");
        g.modificarEnergia(0);
    }

    @Override
    public Equipo actualizar() {
        System.out.print(", tenes todo el equipamiento, no recibis nada");
        return this;
    }

    @Override
    public void abrirPuerta (Gladiador g, Camino c) {
        System.out.print("\n"+ g.nombre + " GANASTE!!!, llegaste y abriste la puerta del monte Vesubio!!!!");
        throw new Ganador();
    }

}
