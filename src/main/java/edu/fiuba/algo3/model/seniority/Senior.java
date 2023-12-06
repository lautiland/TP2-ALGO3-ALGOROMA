package edu.fiuba.algo3.model.seniority;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Senior extends Seniority {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 10;

    public Senior() {
        this.experiencia = 12;
    }

    @Override
    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " consigue " + PUNTOS_DE_ENERGIA_GANADOS + " puntos de energia por ser Senior");
        gladiador.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
        return this;
    }
}
