package edu.fiuba.algo3.modelo;

public class DataClassCelda {
    private final int X;
    private final int Y;
    private final String premio;
    private final String obstaculo;

    public DataClassCelda(int x, int y, String premio, String obstaculo) {
        this.X = x;
        this.Y = y;
        this.obstaculo = obstaculo;
        this.premio = premio;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String getPremio() {
        return premio;
    }

    public String getObstaculo() {
        return obstaculo;
    }
}
