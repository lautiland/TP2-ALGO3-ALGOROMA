package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.Eliminado;

public class Tiradas {

    private int tiradas = 0;
    private final static int TIRADAS_MAXIMAS = 30;

    private final Dado dado;

    public Tiradas(Dado dado) {
        this.dado = dado;
    }

    public int tirarDado() {
        if (this.tiradas < TIRADAS_MAXIMAS) {
            this.tiradas += 1;
            return this.dado.tirar();
        }
        return 0;
    }

    public void verificarLimite(Gladiador gladiador) {
        if (this.tiradas >= TIRADAS_MAXIMAS) {
            System.out.println(gladiador.NOMBRE + " eliminado");
            throw new Eliminado();
        }
    }
}
