package edu.fiuba.algo3.model.tablero;

public class CeldaSinCasilla implements Celda {
    @Override
    public String nombrePremio() {
        return "vacio";
    }

    @Override
    public String nombreObstaculo() {
        return "vacio";
    }

    @Override
    public boolean equals(String tipo) {
        return tipo.equalsIgnoreCase("vacio");
    }
}
