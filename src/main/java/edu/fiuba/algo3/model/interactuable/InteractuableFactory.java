package edu.fiuba.algo3.model.interactuable;

public class InteractuableFactory {

    public static Interactuable crearInteractuable(String interactuable) {
        switch (interactuable) {
            case "Comida":
                return new Comida();
            case "Equipamiento":
                return new Equipamiento();
            case "Bacanal":
                return new Bacanal();
            case "Fiera":
                return new Fiera();
            case "Lesion":
                return new Lesion();
            case "Llegada":
                return new Llegada();
            default:
                return new SinInteraccion();
        }
    }
}
