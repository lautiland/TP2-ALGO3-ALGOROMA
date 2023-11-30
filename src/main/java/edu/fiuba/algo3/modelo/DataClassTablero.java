package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class DataClassTablero {

    public final int ANCHO;
    public final int LARGO;

    public final List<DataClassCelda> camino = new ArrayList<>();

    public DataClassTablero(int ancho, int largo) {
        this.ANCHO = ancho;
        this.LARGO = largo;
    }
}
