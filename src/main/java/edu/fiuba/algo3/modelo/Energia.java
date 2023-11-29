package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.estado.SinEnergia;

public class Energia {

    private int puntos = 20;

    public Estado atualizarSinEnergia(Estado estado) {
        if (this.puntos <= 0) {
            return new SinEnergia();
        }
        return estado;
    }

    public Estado atualizarConEnergia(Estado estado) {
        if (this.puntos > 0) {
            return new Sano();
        }
        return estado;
    }

    public void modificarPuntos(int cantidad) {
        this.puntos += cantidad;
        System.out.print(" (" + this.puntos + ")");
    }

    public boolean tenes(int puntos) {
        return this.puntos == puntos;
    }


}
