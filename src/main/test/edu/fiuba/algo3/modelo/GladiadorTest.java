package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GladiadorTest {

    @Test
    public void test05gladiadorRecibeCasco() {
        //Act
        Gladiador gladiador = new Gladiador();

        // Arrange
        gladiador.recibirPremio();
        Equipamiento equipo = gladiador.getEquipo();
        Casco casco = new Casco();

        // Assert
        assertEquals(casco.getClass(), equipo.getClass());
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
        Equipamiento equipo = gladiador.getEquipo();


        // Assert
        assertEquals(escudoYEspada.getClass(), equipo.getClass());
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {

        //Act
        Gladiador gladiador = new Gladiador();

        //Arrange
        gladiador.recibirPremio();
        gladiador.esAtacado();

        //Assert
        assertEquals(5, gladiador.getEnergia().getPuntos());
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
        assertEquals(25, gladiador.getEnergia().getPuntos());
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
        assertEquals(20, gladiador.getEnergia().getPuntos());
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
        assertEquals(llave.getClass(), gladiador.getEquipo().getClass());
    }


}