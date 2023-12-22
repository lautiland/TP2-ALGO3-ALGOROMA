package edu.fiuba.algo3.model.tablero;

public class CeldaSinCasilla implements Celda {
    @Override
    public String nombrePremio() {
        return "sininteraccion";
    }

    @Override
    public String nombreObstaculo() {
        return "sininteraccion";
    }

    @Override
    public boolean equals(String tipo) {
        return tipo.equalsIgnoreCase("sininteraccion");
    }
}
