package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.camino.CaminoTipo;
import edu.fiuba.algo3.modelo.efectos.Efecto;

public class Casilla {

    private final Efecto efecto;
    private final CaminoTipo tipo;


    public Casilla(Efecto e, CaminoTipo t) {
        this.efecto = e;
        this.tipo = t;
    }

    public void aplicarEfecto(Gladiador g) {
        this.efecto.aplicar(g);
    }
}
