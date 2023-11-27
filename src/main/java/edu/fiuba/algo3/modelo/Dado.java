package edu.fiuba.algo3.modelo;

import java.util.Random;
import java.util.Scanner;

public class Dado {

    public static int tirar(){
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        return new Random().nextInt(5) + 1;
    }
}
