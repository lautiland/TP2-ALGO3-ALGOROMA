package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.camino.CaminoTipo;

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

    //para la interfaz grafica
    public void pintar() {
        this.tipo.pintar();
    }
}
