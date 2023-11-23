package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    public static int tirar(){
        return new Random().nextInt(5) + 1;
    }
}
