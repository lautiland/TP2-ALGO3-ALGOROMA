package edu.fiuba.algo3.modelo.parser;

public class DataClassCelda {
    public final int X;
    public final int Y;
    public final String premio;
    public final String obstaculo;

    public DataClassCelda(int x, int y, String premio, String obstaculo) {
        this.X = x;
        this.Y = y;
        this.obstaculo = obstaculo;
        this.premio = premio;
    }
}
