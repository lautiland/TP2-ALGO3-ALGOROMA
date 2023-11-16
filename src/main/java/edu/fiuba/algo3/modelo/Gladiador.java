package edu.fiuba.algo3.modelo;

public class Gladiador {

    private Energia energia;
    private Nivel nivel;
    private int posicionTablero;

    private Equipamiento equipo;
    private int turnosJugados = 0;

    public Gladiador() {
        this.energia = new Energia();
        this.setNivel(new Novato());
        this.equipo = new Vacio();
    }

    public void setNivel(Nivel n) {
        this.nivel = n;
        this.nivel.setGladiador(this);
    }

    public void jugar() {
        this.turnosJugados += 1;
        this.nivel.sumarPuntos(this.energia, this.turnosJugados);
    }

    public void recibirPremio() {
        this.equipo = this.equipo.actualizarEquipo();
    }

    public void esAtacado() {
        this.equipo.resistirAtaque(this.energia);
    }

    public Equipamiento getEquipo() {
        return this.equipo;
    }

    public Energia getEnergia() {
        return this.energia;
    }

    public Nivel getNivel() {
        return this.nivel;
    }

}
