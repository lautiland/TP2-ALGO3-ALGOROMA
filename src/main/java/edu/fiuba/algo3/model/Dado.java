package edu.fiuba.algo3.model;

import java.util.Random;

public class Dado {
    public int tirar() {
        return new Random().nextInt(5) + 1;
    }
}
