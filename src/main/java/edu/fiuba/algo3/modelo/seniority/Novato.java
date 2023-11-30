package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Gladiador;

public class Novato extends Seniority {

    public Novato() {
        this.experiencia = 0;
    }

    @Override
    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        if (this.experiencia == 8) {
            System.out.print(", subiste de nivel a SemiSenior");
            return new SemiSenior().actualizar(gladiador);
        }
        return this;

    }

}
