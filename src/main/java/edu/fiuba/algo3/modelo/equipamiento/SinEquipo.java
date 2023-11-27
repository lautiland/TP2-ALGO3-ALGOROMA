package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class SinEquipo extends Equipo {

    @Override
    public void resistirAtaque(Gladiador g) {
        System.out.print(", perdes 20 puntos de energia");
        g.modificarEnergia(-20);
    }

    @Override
    public Equipo actualizar() {
        System.out.print(", recibiste casco");
        return new Casco();
    }
}
