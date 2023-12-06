package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.estado.Estado;
import edu.fiuba.algo3.model.estado.SinEnergia;

public class Energia {

    private int puntos = 20;

    public Estado actualizarEstado(Estado estado) {
        if (this.puntos <= 0) {
            return new SinEnergia();
        }
        return estado;
    }

    public void modificarPuntos(int cantidad) {
        this.puntos += cantidad;
        Logger.getInstance().info("El gladiador ahora tiene " + this.puntos + " puntos de energía");
    }

    public boolean tenes(int puntos) {
        return this.puntos == puntos;
    }

}
