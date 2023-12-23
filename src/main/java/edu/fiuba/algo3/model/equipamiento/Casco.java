package edu.fiuba.algo3.model.equipamiento;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Casco extends Equipamiento {

    private static final int PUNTOS_DANIO = -15;

    @Override
    public void resistirAtaque(Gladiador gladiador) {
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " tiene un casco, pierde 15 puntos de energia");
        gladiador.modificarEnergia(PUNTOS_DANIO);
    }

    @Override
    public Equipamiento actualizar() {
        Logger.getInstance().info("El gladiador recibe una armadura");
        return new Armadura();
    }

    @Override
    public String toString() {
        return "casco";
    }
}
