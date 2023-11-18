package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.efectos.*;

public class EfectoFactory {

    public Efecto crearEfecto(String efecto) {
        if (efecto.contentEquals("Comida"))
            return new Comida();

        if (efecto.contentEquals("Equipamiento"))
            return new Equipamiento();

        if (efecto.contentEquals("Bacanal"))
            return new Bacanal(4);

        if (efecto.contentEquals("Fiera"))
            return new Fiera();

        if (efecto.contentEquals("Lesion"))
            return new Lesion();

        return null;
    }
}
