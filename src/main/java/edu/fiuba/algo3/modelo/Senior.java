package edu.fiuba.algo3.modelo;

public class Senior implements Nivel {

    private Gladiador gladiador;
    @Override
    public void sumarPuntos(Energia e, int turnosJugados) {
        e.sumarPuntos(10);
    }

    @Override
    public void setNivel(Gladiador g) {
        this.gladiador = g;
    }

    @Override
    public void verNivel() {
        System.out.println("Senior");
    }
}
