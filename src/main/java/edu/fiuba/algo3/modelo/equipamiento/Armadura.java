package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Armadura extends Equipo {

    @Override
    public void resistirAtaque(Gladiador g) {
        System.out.print(", perdes 10 puntos de energia");
        g.modificarEnergia(-10);
    }

    @Override
    public Equipo actualizar() {
        System.out.print(", recibiste Escudo y espada");
        return new EscudoYEspada();
    }
}
