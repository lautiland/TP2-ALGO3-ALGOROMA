package edu.fiuba.algo3.modelo.efectos;

import edu.fiuba.algo3.modelo.efectos.*;

public class EfectoFactory {

    public static Efecto crearEfecto(String efecto) {

        switch (efecto) {
            case "Comida":
                return new Comida();
            case "Equipamiento":
                return new Equipamiento();
            case "Bacanal":
                return new Bacanal(4);
            case "Fiera":
                return new Fiera();
            case "Lesion":
                return new Lesion();
            default:
                return new Ninguno();
        }
    }
}
