package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoRoma;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //App.main(args);
        AlgoRoma algoRoma = new AlgoRoma();
        try {
            algoRoma.iniciarJuegoCompleto();
            algoRoma.jugar();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
