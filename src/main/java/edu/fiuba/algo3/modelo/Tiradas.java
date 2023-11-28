package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.Eliminado;

public class Tiradas {

    private int tiradas = 0;
    private final static int TIRADAS_MAXIMAS = 30;

    public int tirarDado() {
        if (this.tiradas < TIRADAS_MAXIMAS) {
            this.tiradas += 1;
            return Dado.tirar();
        }
        return 0;
    }

    public void verificarLimite(Gladiador g) {
        if (this.tiradas >= TIRADAS_MAXIMAS) {
            System.out.println(g.nombre + " eliminado");
            throw new Eliminado();
        }
    }
}
