package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class DataClassTablero {

    public final int ancho;
    public final int largo;

    public final List<DataClassCelda> camino = new ArrayList<>();

    public DataClassTablero(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }
}
