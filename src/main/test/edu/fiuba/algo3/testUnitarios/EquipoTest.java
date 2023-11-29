package edu.fiuba.algo3.testUnitarios;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquipoTest {

    @Test
    public void test01ArmaduraResta10PuntosDeEnergia() {
        //Arrange
        Gladiador pepe = new Gladiador("Pepe", new Dado());

        //Act
        pepe.actualizarEquipo(); //obtiene casco
        pepe.actualizarEquipo(); //obtiene armadura
        pepe.recibirAtaque();

        //Assert, pepe inicia con 20 puntos
        assertTrue(pepe.tenesPuntosDeEnegia(10));

    }

    @Test
    public void test02EscudoYEspadaResta2PuntosDeEnergia() {
        //Arrange
        Gladiador pepe = new Gladiador("Pepe", new Dado());

        //Act
        pepe.actualizarEquipo(); //obtiene casco
        pepe.actualizarEquipo(); //obtiene armadura
        pepe.actualizarEquipo(); //escudo y espada
        pepe.recibirAtaque();

        //Assert, pepe inicia con 20 puntos
        assertTrue(pepe.tenesPuntosDeEnegia(18));

    }
}
