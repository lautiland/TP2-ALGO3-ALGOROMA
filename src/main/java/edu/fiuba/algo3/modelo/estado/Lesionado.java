package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;

public class Lesionado implements Estado {
    @Override
    public Estado jugar(Gladiador gladiador) {
        System.out.print(gladiador.nombre + " estas lesionado, perdes el turno");
        return new Sano();
    }
}
