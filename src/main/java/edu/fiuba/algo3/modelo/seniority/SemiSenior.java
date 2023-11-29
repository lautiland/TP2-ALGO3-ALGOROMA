package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Gladiador;

public class SemiSenior extends Seniority {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 5;
    public SemiSenior() {
        this.experiencia = 8;
    }

    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        System.out.print(", ganaste " + PUNTOS_DE_ENERGIA_GANADOS + " por ser SemiSenior");
        gladiador.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
        if (this.experiencia == 12) {
            System.out.print(", subiste de nivel a Senior");
            return new Senior();
        }
        return this;
    }
}
