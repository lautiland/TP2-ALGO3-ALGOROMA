package edu.fiuba.algo3.model.interactuable;

public class InteractuableFactory {

    public static Interactuable crearInteractuable(String interactuable) {
        switch (interactuable) {
            case "comida":
                return new Comida();
            case "equipamiento":
                return new Equipamiento();
            case "bacanal":
                return new Bacanal();
            case "fiera":
                return new Fiera();
            case "lesion":
                return new Lesion();
            case "llegada":
                return new Llegada();
            default:
                return new SinInteraccion();
        }
    }
}
