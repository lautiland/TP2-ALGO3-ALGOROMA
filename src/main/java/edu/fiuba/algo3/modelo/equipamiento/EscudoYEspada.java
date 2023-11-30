package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Gladiador;

public class EscudoYEspada extends Equipamiento {

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        System.out.print(", perdes 2 puntos de energia");
        gladiador.modificarEnergia(-2);
    }

    @Override
    public Equipamiento actualizar() {
        System.out.print(", recibiste llave");
        return new Llave();
    }

}
