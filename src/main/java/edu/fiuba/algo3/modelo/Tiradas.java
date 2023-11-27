package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.observer.Observador;

public class Tiradas {

    private int tiradas = 0;
    private final int TIRADAS_MAXIMAS = 30;
    private Observador observador;

    public void enlazarObservador(Observador o) {
        this.observador = o;
    }

    public int tirarDado() {
        if (this.tiradas < this.TIRADAS_MAXIMAS) {
            this.tiradas += 1;
            return Dado.tirar();
        }
        return 0;
    }

    public void verificarLimite(Gladiador g) {
        if (this.tiradas >= this.TIRADAS_MAXIMAS) {
            this.observador.eliminarJugador(g);
        }
    }
}
