package edu.fiuba.algo3.modelo;

public class SemiSenior implements Nivel{

    private Gladiador gladiador;
    @Override
    public void sumarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(5);
        if (turnosJugados == 9)
            this.gladiador.setNivel(new Senior());
    }

    @Override
    public void setGladiador(Gladiador g) {
        this.gladiador = g;
    }
}
