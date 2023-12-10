package edu.fiuba.algo3.model.tablero;

public interface Celda {
    String nombrePremio();

    String nombreObstaculo();

    boolean equals(String tipo);
}
