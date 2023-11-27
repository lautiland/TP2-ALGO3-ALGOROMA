package edu.fiuba.algo3.modelo.interactuable;

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
            default:
                return new Ninguno();
        }
    }
}
