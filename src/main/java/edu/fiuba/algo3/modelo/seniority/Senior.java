package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Gladiador;

public class Senior extends Seniority {

    private static final int PUNTOS_DE_ENERGIA_GANADOS = 10;
    public Senior() {
        this.experiencia = 12;
    }

    @Override
    public Seniority actualizar(Gladiador g) {
        this.experiencia += 1;
        System.out.print(", ganaste " + PUNTOS_DE_ENERGIA_GANADOS + " por senior");
        g.modificarEnergia(PUNTOS_DE_ENERGIA_GANADOS);
        return this;
    }
}
