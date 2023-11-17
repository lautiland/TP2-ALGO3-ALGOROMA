package edu.fiuba.algo3.modelo;

public class Novato implements Nivel{

    private Gladiador gladiador;

    @Override
    public void setGladiador(Gladiador g) {
        this.gladiador = g;
    }

    @Override
    public void sumarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(0);
        if (turnosJugados == 8)
            gladiador.setNivel(new SemiSenior());

    }

}
