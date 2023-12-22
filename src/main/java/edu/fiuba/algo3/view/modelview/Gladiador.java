package edu.fiuba.algo3.view.modelview;

public class Gladiador {
    private final String modelName;
    private int posicionX;
    private int posicionY;

    public Gladiador(String gladiadorNombre, int numeroDeGladiador) {
        modelName = gladiadorNombre;
    }
    public String getModelNombre() {
        return modelName;
    }
    public void mover (int numeroDeCasillaX, int numeroDeCasillaY) {
        posicionX = numeroDeCasillaX;
        posicionY = numeroDeCasillaY;
    }
    public int getPosicionX() {
        return posicionX;
    }
    public int getPosicionY() {
        return posicionY;
    }

}

