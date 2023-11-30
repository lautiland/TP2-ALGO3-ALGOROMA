package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class Armadura extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        System.out.print(", perdes 10 puntos de energia");
        gladiador.modificarEnergia(-10);
    }

    @Override
    public Equipamiento actualizar() {
        System.out.print(", recibiste Escudo y espada");
        return new EscudoYEspada();
    }
}
