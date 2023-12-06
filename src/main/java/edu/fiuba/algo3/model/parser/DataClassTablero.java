package edu.fiuba.algo3.model.parser;

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

    public List<DataClassCelda> getCamino() {
        return camino.subList(0, camino.size() - 1);
    }

    public DataClassCelda getLlegada() {
        return camino.get(camino.size() - 1);
    }

    public void agregarCelda(DataClassCelda celda) {
        this.camino.add(celda);
    }
}
