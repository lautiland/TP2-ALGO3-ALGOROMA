package edu.fiuba.algo3.modelo;

public class DataClassCelda {
    public final int x;
    public final int y;
    public final String premio;
    public final String obstaculo;

    public DataClassCelda(int x, int y, String premio,String obstaculo) {
        this.x = x;
        this.y = y;
        this.obstaculo = obstaculo;
        this.premio = premio;
    }

}
