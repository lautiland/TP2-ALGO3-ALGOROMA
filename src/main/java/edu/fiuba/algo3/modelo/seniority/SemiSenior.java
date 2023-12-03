package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Logger;

public class SemiSenior extends Seniority {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 5;

    public SemiSenior() {
        this.experiencia = 8;
    }

    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " consigue " + PUNTOS_DE_ENERGIA_GANADOS + " puntos de energia por ser SemiSenior");
        gladiador.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
        if (this.experiencia == 12) {
            Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " subió de nivel a Senior");
            return new Senior().actualizar(gladiador);
        }
        return this;
    }
}
