package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class DataClassTablero {

    private final int ANCHO;
    private final int LARGO;
    private final List<DataClassCelda> camino = new ArrayList<>();

    public DataClassTablero(int ancho, int largo) {
        this.ANCHO = ancho;
        this.LARGO = largo;
    }

    public int getLARGO() {
        return LARGO;
    }

    public int getANCHO() {
        return ANCHO;
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
