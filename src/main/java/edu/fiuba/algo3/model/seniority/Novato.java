package edu.fiuba.algo3.model.seniority;

import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;

public class Novato extends Seniority {

    public Novato() {
        this.experiencia = 0;
    }

    @Override
    public Seniority actualizar(Gladiador gladiador) {
        this.experiencia += 1;
        if (this.experiencia == 8) {
            Logger.getInstance().info("El gladiador " + gladiador.getNombre() + " subió de nivel a SemiSenior");
            return new SemiSenior().actualizar(gladiador);
        }
        return this;

    }

}
