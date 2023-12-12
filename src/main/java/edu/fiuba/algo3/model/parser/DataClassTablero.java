package edu.fiuba.algo3.model.parser;

import java.util.ArrayList;
import java.util.List;

public class DataClassTablero {

    public final int ANCHO;
    public final int LARGO;
    public final List<DataClassCelda> CAMINO = new ArrayList<>();

    public DataClassTablero(int ancho, int largo) {
        this.ANCHO = ancho;
        this.LARGO = largo;
    }

    public List<DataClassCelda> getCamino() {
        return CAMINO.subList(0, CAMINO.size() - 1);
    }

    public DataClassCelda getLlegada() {
        return CAMINO.get(CAMINO.size() - 1);
    }

    public void agregarCelda(DataClassCelda celda) {
        this.CAMINO.add(celda);
    }
}
