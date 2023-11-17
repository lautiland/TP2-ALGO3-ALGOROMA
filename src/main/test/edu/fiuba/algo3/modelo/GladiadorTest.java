package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.Casco;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.equipamiento.EscudoYEspada;
import edu.fiuba.algo3.modelo.equipamiento.Llave;
import edu.fiuba.algo3.modelo.nivel.Novato;
import edu.fiuba.algo3.modelo.nivel.SemiSenior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GladiadorTest {

    @Test
    public void test05gladiadorRecibeCasco() {
        //Act
        Gladiador gladiador = new Gladiador();
        Casco casco = new Casco();

        // Arrange
        gladiador.recibirPremio();

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(casco));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Act
        Gladiador gladiador = new Gladiador();
        EscudoYEspada escudoYEspada = new EscudoYEspada();

        // Arrange
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(escudoYEspada));
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {

        //Act
        Gladiador gladiador = new Gladiador();

        //Arrange
        gladiador.recibirPremio();
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesEstosPuntosDeEnegia(5));
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arrange
        Gladiador gladiador = new Gladiador();
        Novato novato = new Novato();
        SemiSenior semiSenior = new SemiSenior();

        //ver el nivel inicial
        assertEquals(novato.getClass(), gladiador.getNivel().getClass());

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.jugar();
        }

        // Sube a semi senior
        assertEquals(semiSenior.getClass(), gladiador.getNivel().getClass());

        gladiador.jugar();
        //sube 5 puntos de los 20 iniciales
        assertTrue(gladiador.tenesEstosPuntosDeEnegia(25));
    }

    @Test
    public void test10gladiadorEsAtacadoYNoReciveDanioPorPoseerTodoElEquipo() {
        //Act
        Gladiador gladiador = new Gladiador();

        // Arrange
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesEstosPuntosDeEnegia(20));
    }

    @Test
    public void test11gladiadorTieneLlaveYRecibeOtroPremioNoCambiaNada() {
        //Act
        Gladiador gladiador = new Gladiador();
        Llave llave = new Llave();

        // Arrange
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();

        gladiador.recibirPremio();

        //Assert
        assertTrue(gladiador.tenesEsteEquipo(llave));
    }


}