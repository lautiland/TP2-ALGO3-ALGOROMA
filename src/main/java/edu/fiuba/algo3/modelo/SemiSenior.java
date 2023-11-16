package edu.fiuba.algo3.modelo;

public class SemiSenior implements Nivel{

    private Gladiador gladiador;
    @Override
    public void sumarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(5);
        if (turnosJugados == 12)
            gladiador.setNivel(new Senior());
    }

    @Override
    public void setNivel(Gladiador g) {
        this.gladiador = g;
    }

    @Override
    public void verNivel() {
        System.out.println("SemiSenior");
    }
}
