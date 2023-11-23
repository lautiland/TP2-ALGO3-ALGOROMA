package edu.fiuba.algo3.entrega_1;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.efectos.*;
import edu.fiuba.algo3.modelo.equipamiento.*;
import edu.fiuba.algo3.modelo.nivel.Novato;
import edu.fiuba.algo3.modelo.nivel.SemiSenior;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerEntregaTest {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Equipo sinEquipo = new SinEquipo();
        //Act

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
        assertTrue(gladiador.tenesEsteEquipo(sinEquipo));
    }

    @Test
    public void test02JugadorSaleDeLaCasillaInicial(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador("Pepe");
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        gladiadores.add(gladiador);
        Tablero tablero = new Tablero(gladiadores, new ArrayList<>());

       tablero.avanzar(gladiador, new Dado());

        assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }

    @Test
    public void test02ConTableroBJugadorSaleDeLaCasillaInicial() throws IOException {
        //Arrange
        List<JsonObject> mapa = AlgoRoma.obtenerListaDatosDesdeJson("mapa.json");
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        gladiadores.add(new Gladiador("Pepe"));
        gladiadores.add(new Gladiador("Jose"));
        TableroB tablero = new TableroB(gladiadores, mapa);

        //Act
        tablero.mover(gladiadores.get(0), 3);

        //Assert
        assertTrue(tablero.estaEl(gladiadores.get(0), 3));
    }

    @Test
    public void test03NoPuedeJugarUnTurnoSinEnergia(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador("Pepe");
        ArrayList<Gladiador> gladiadores = new ArrayList<Gladiador>();
        gladiadores.add(gladiador);
        //Tablero tablero = new Tablero(gladiadores, new ArrayList<Fiera>(new Fiera()));

        //tablero.avanzar(gladiador, new Dado());

        //assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }

    @Test
    public void test03JugadorSinEnergiaNoJuega() throws IOException {
        //Arrange, para este test, se debe poner t.mover a 7 en la clase Sano
        List<JsonObject> mapa = AlgoRoma.obtenerListaDatosDesdeJson("mapa.json");
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Pepe");
        gladiadores.add(gladiador);
        TableroB tablero = new TableroB(gladiadores, mapa);

        //Act
        gladiador.turnoEn(tablero);

        //para ver si esta en 7
        assertTrue(tablero.estaEl(gladiador, 7));

        gladiador.turnoEn(tablero);

        //Assert jugador no avanza, esta en la misma posicion
        assertTrue(tablero.estaEl(gladiador, 7));
    }


    @Test
    public void test04RecibeComidaIncrementaEnergiaEn10() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Efecto premio = new Comida();

        //Act
        premio.aplicar(gladiador);

        //Assert 20 iniciales + 10 por comer
        assertTrue(gladiador.tenesPuntosDeEnegia(30));
    }


    @Test
    public void test05gladiadorRecibeCasco() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Casco casco = new Casco();
        Efecto premio = new Equipamiento();

        //Act
        premio.aplicar(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(casco));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Efecto premio = new Equipamiento();

        //Act
        premio.aplicar(gladiador);
        premio.aplicar(gladiador);
        premio.aplicar(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(new EscudoYEspada()));
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {

        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Efecto efecto = EfectoFactory.crearEfecto("Equipamiento");
        Casilla casilla = new Casilla(efecto, new Camino());

        //Act
        casilla.aplicarEfecto(gladiador);
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arramge
        Gladiador gladiador = new Gladiador("Pepe");
        Novato novato = new Novato();
        SemiSenior semiSenior = new SemiSenior();

        //ver el nivel inicial
        assertTrue(gladiador.tenesElNivel(novato));

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.actualizarPuntosSegunNivel();
        }

        // Sube a semi senior
        assertTrue(gladiador.tenesElNivel(semiSenior));

        gladiador.actualizarPuntosSegunNivel();

        //Assert, sube 5 puntos de los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(25));
    }

    @Test
    public void test09GladiadorLlegaAMetaSinLlaveRetroceAMitadDeCamino() throws IOException {
        //Arrange
        List<JsonObject> mapa = AlgoRoma.obtenerListaDatosDesdeJson("mapa.json");
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Pepe");
        gladiadores.add(gladiador);
        TableroB tablero = new TableroB(gladiadores, mapa);

        //Act gladiador se mueve hasta el fin
        tablero.mover(gladiador, 50);

        //Assert el jugador vuelve a mitad de camino
        assertTrue(tablero.estaEl(gladiador, 8));
    }

    @Test
    public void test10gladiadorEsAtacadoYNoReciveDanioPorPoseerTodoElEquipo() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Efecto obstaculo = new Fiera();

        //Act
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();

        obstaculo.aplicar(gladiador);

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
    }

    @Test
    public void test11gladiadorTieneLlaveYRecibeOtroPremioNoCambiaNada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Llave llave = new Llave();

        //Act
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();

        gladiador.actualizarEquipo();

        //Assert
        assertTrue(gladiador.tenesEsteEquipo(llave));
    }

    @Test
    public void test12SinNadieGanaDespuesDe30RondasFinalizaElJuego() throws IOException {
        //Arrange
        AlgoRoma algoRoma = new AlgoRoma();

        //Act
        algoRoma.iniciarJuego();
        int valorFin = algoRoma.jugar();

        //Assert cuando finaliza el juego, retorna 0
        assertEquals(0, valorFin);


    }

}
