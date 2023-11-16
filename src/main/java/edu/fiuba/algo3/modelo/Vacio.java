package edu.fiuba.algo3.modelo;

public class Vacio implements Equipamiento{
    @Override
    public void resistir(Energia e) {
        e.restarPuntos(20);
    }

    @Override
    public Equipamiento actualizarEquipo() {
        return new Casco();
    }
}
