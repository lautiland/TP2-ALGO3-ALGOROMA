package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Efecto;
import edu.fiuba.algo3.modelo.Gladiador;

public class Bacanal implements Efecto {

    private final int puntosPorTrago;

    public Bacanal(int puntosPorTrago) {
        this.puntosPorTrago = puntosPorTrago;
    }
    @Override
    public void aplicar(Gladiador g) {
        Dado dado = new Dado();
        g.beber(this.puntosPorTrago*dado.tirar());
    }
}
