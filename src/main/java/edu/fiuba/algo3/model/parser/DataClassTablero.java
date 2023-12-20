package edu.fiuba.algo3.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataClassTablero {

    public final int ANCHO;
    public final int LARGO;
    public final List<DataClassCelda> CELDAS = new ArrayList<>();

    public DataClassTablero(int ancho, int largo) {
        this.ANCHO = ancho;
        this.LARGO = largo;
    }
    public DataClassCelda getInicio() {
        return CELDAS.get(0);
    }

    public List<DataClassCelda> getCeldasSinInicioNiLlegada() {
        List<DataClassCelda> camino = new ArrayList<>();
        for (DataClassCelda celda : this.CELDAS) {
            if (Objects.equals(celda.TIPO, "camino")) {
                camino.add(celda);
            }
        }
        return camino;
    }
    public List<DataClassCelda> getCeldas() {
        return CELDAS;
    }

    public DataClassCelda getLlegada() {
        return CELDAS.get(CELDAS.size() - 1);
    }

    public void agregarCelda(DataClassCelda celda) {
        this.CELDAS.add(celda);
    }
}
