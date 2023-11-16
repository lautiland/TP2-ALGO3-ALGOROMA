package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    public Dado(){

    }

    public int tirar(){
        return new Random().nextInt(5) + 1;
    }
}
