package edu.fiuba.algo3.model.parser;

public class DataClassCelda {
    public final int X;
    public final int Y;
    public final String PREMIO;
    public final String OBSTACULO;

    public DataClassCelda(int x, int y, String premio, String obstaculo) {
        this.X = x;
        this.Y = y;
        this.OBSTACULO = obstaculo;
        this.PREMIO = premio;
    }
}
