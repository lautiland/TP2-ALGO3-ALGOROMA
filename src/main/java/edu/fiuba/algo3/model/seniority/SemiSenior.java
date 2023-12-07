package edu.fiuba.algo3.model.seniority;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class SemiSenior extends Seniority {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 5;
    private static final int PUNTOS_NECESARIO_SIGUIENTE_NIVEL = 12;
    private static final int PUNTOS_EXPERIENCIA_INICIAL = 8;

    public SemiSenior() {
        this.experiencia = PUNTOS_EXPERIENCIA_INICIAL;
    }

    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " consigue " + PUNTOS_DE_ENERGIA_GANADOS + " puntos de energia por ser SemiSenior");
        gladiador.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
        if (this.experiencia == PUNTOS_NECESARIO_SIGUIENTE_NIVEL) {
            Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " subió de nivel a Senior");
            return new Senior().actualizar(gladiador);
        }
        return this;
    }
}
