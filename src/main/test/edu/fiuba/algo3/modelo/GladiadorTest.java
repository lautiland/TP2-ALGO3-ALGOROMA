package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GladiadorTest {

    @Test
    public void gladiadorSubeDeNivelCorrectamente() {
        // Arrange
        Gladiador gladiador = new Gladiador();
        Nivel nivelMock = mock(Nivel.class);
        gladiador.setNivel(nivelMock);

        // Act
        for (int turno = 1; turno < 13; turno++) {
            gladiador.jugar();
        }

        // Assert
        verify(nivelMock, times(1)).setGladiador(gladiador);
        verify(nivelMock, times(1)).sumarPuntos(any(Energia.class), eq(8)); // Verifica la transición a SemiSenior
        verify(nivelMock, times(1)).sumarPuntos(any(Energia.class), eq(12)); // Verifica la transición a Senior
    }

    @Test
    public void test02gladiadorRecibeCasco() {
        //Act
        Gladiador gladiador = new Gladiador();

        // Arrange
        gladiador.recibirPremio();
        Equipamiento equipo = gladiador.getUltimoEquipo();
        Casco casco = new Casco();

        // Assert
        assertEquals(casco.getClass(), equipo.getClass());
    }

    @Test
    public void test03gladiadorRecibeLEscudoYEspada() {
        //Act
        Gladiador gladiador = new Gladiador();
        EscudoYEspada escudoYEspada = new EscudoYEspada();

        // Arrange
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        gladiador.recibirPremio();
        Equipamiento equipo = gladiador.getUltimoEquipo();


        // Assert
        assertEquals(escudoYEspada.getClass(), equipo.getClass());
    }

    @Test
    public void test04gladiadorEsAtacadoYPierde15Puntos() {

        //Act
        Gladiador gladiador = new Gladiador();

        //Arrange
        gladiador.recibirPremio();
        gladiador.esAtacado();

        //Assert
        assertEquals(5, gladiador.getEnergia().getPuntos());
    }


}