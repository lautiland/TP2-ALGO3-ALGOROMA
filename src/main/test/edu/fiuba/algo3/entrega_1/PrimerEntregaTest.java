package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.nivel.Novato;
import edu.fiuba.algo3.modelo.nivel.SemiSenior;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.Equipamiento;
import edu.fiuba.algo3.modelo.premio.equipamiento.*;
import edu.fiuba.algo3.modelo.premio.Premio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerEntregaTest {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){
        //Act
        Gladiador gladiador = new Gladiador();
        Equipo sinEquipo = new SinEquipo();
        //Arrange

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
        assertTrue(gladiador.tenesEsteEquipo(sinEquipo));
    }

    @Test
    public void test02JugadorSaleDeLaCasillaInicial(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador();
        ArrayList<Gladiador> gladiadores = new ArrayList<Gladiador>();
        gladiadores.add(gladiador);
        Tablero tablero = new Tablero(gladiadores, new ArrayList<Fiera>());

       tablero.avanzar(gladiador, new Dado());

        assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }

    @Test
    public void test03NoPuedeJugarUnTurnoSinEnergia(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador();
        ArrayList<Gladiador> gladiadores = new ArrayList<Gladiador>();
        gladiadores.add(gladiador);
        //Tablero tablero = new Tablero(gladiadores, new ArrayList<Fiera>(new Fiera()));

        //tablero.avanzar(gladiador, new Dado());

        //assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }


    @Test
    public void test04RecibeComidaIncrementaEnergiaEn10() {
        //Act
        Gladiador gladiador = new Gladiador();
        Premio premio = new Comida();

        //Arrange
        premio.aplicarEfecto(gladiador);

        //Assert 20 iniciales + 10 por comer
        assertTrue(gladiador.tenesPuntosDeEnegia(30));
    }


    @Test
    public void test05gladiadorRecibeCasco() {
        //Act
        Gladiador gladiador = new Gladiador();
        Casco casco = new Casco();
        Premio premio = new Equipamiento();

        // Arrange
        premio.aplicarEfecto(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(casco));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Act
        Gladiador gladiador = new Gladiador();
        Premio premio = new Equipamiento();

        // Arrange
        premio.aplicarEfecto(gladiador);
        premio.aplicarEfecto(gladiador);
        premio.aplicarEfecto(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(new EscudoYEspada()));
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {

        //Act
        Gladiador gladiador = new Gladiador();

        //Arrange
        gladiador.actualizarEquipo();
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
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
        assertTrue(gladiador.tenesPuntosDeEnegia(25));
    }

    @Test
    public void test10gladiadorEsAtacadoYNoReciveDanioPorPoseerTodoElEquipo() {
        //Act
        Gladiador gladiador = new Gladiador();

        // Arrange
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
    }

    @Test
    public void test11gladiadorTieneLlaveYRecibeOtroPremioNoCambiaNada() {
        //Act
        Gladiador gladiador = new Gladiador();
        Llave llave = new Llave();

        // Arrange
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();

        gladiador.actualizarEquipo();

        //Assert
        assertTrue(gladiador.tenesEsteEquipo(llave));
    }

}
