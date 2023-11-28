package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.interactuable.*;
import edu.fiuba.algo3.modelo.equipamiento.*;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    public void test02JugadorSaleDeLaCasillaInicial() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiadorPepe = new Gladiador("Pepe");
        gladiadores.add(gladiadorPepe);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act
        camino.mover(gladiadorPepe, 2);


        //Assert
        assertTrue(camino.estaEl(gladiadorPepe, 2));

    }

    @Test
    public void test03JugadorSinEnergiaNoJuega() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiadorPepe = new Gladiador("Pepe");
        gladiadores.add(gladiadorPepe);
        Camino camino = new Camino(gladiadores);
        for (int celda = 1; celda <= 30; celda++) {
            camino.agregarCasilla(new Casilla(new Ninguno(), new Fiera()));
        }

        //Act
        gladiadorPepe.jugarTurno(camino);
        assertTrue(gladiadorPepe.tenesPuntosDeEnegia(0));

        gladiadorPepe.jugarTurno(camino);

        //Assert jugador no avanza, pero recibe 5 de energia por bono sin energia
        assertTrue(gladiadorPepe.tenesPuntosDeEnegia(5));
    }


    @Test
    public void test04RecibeComidaIncrementaEnergiaEn10() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Interactuable comida = new Comida();

        //Act
        comida.interactuarCon(gladiador);

        //Assert 20 iniciales + 10 por comer
        assertTrue(gladiador.tenesPuntosDeEnegia(30));
    }


    @Test
    public void test05gladiadorRecibeCasco() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Casco casco = new Casco();
        Interactuable premio = new Equipamiento();

        //Act
        premio.interactuarCon(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(casco));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Interactuable premio = new Equipamiento();

        //Act
        premio.interactuarCon(gladiador);
        premio.interactuarCon(gladiador);
        premio.interactuarCon(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(new EscudoYEspada()));
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {

        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");

        //Act
        gladiador.actualizarEquipo();
        gladiador.esAtacado();

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arramge
        Gladiador gladiador = new Gladiador("Pepe");
        Novato novato = new Novato();
        SemiSenior semiSenior = new SemiSenior(8);

        //ver el nivel inicial
        assertTrue(gladiador.tenesElNivel(novato));

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.actualizarSeniority();
        }

        // Sube a semi senior
        assertTrue(gladiador.tenesElNivel(semiSenior));

        gladiador.actualizarSeniority();

        //Assert, sube 5 puntos de los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(25));
    }

    @Test
    public void test09GladiadorLlegaAMetaSinLlaveRetroceAMitadDeCamino() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Pepe");
        gladiadores.add(gladiador);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act gladiador se mueve hasta el fin
        camino.mover(gladiador, 50);

        //Assert el jugador vuelve a mitad de camino
        assertTrue(camino.estaEl(gladiador, 1));
    }

    @Test
    public void test10gladiadorEsAtacadoYNoRecibeDanioPorPoseerTodoElEquipo() {
        //Arrange
        Gladiador gladiador = new Gladiador("Pepe");
        Interactuable obstaculo = new Fiera();

        //Act
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();
        gladiador.actualizarEquipo();

        obstaculo.interactuarCon(gladiador);

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
    public void test12SiNadieGanaDespuesDe30RondasFinalizaElJuego() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Turnos turnos = new Turnos();

        // Act y Assert
        for (int i = 1; i < 30; i++) {
            // Realizar la ejecución del método 30 veces
            turnos.ejecutar(gladiadores, null);
        }

        // Verificar que la excepción se lanza en la ejecución 30
        assertThrows(SinTurnos.class, () -> turnos.ejecutar(gladiadores, null));
    }

    @Test
    public void test13jugadorSanoCambiaDeEstadoALesionadoYVuelveASano() {
        //Arrange, en dado retorna 1, para que avance de a 1
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador pepe = new Gladiador("Pepe");
        gladiadores.add(pepe);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Lesion()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Lesion()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Lesion()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Lesion()));

        //Act
        pepe.jugarTurno(camino);
        pepe.jugarTurno(camino);
        pepe.jugarTurno(camino);
    }

    @Test
    public void test14jugadorSanoCambiaDeEstadoSinEnergiaYVuelveASano() {
        //Arrange, en dado retorna 1, para que avance de a 1
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador pepe = new Gladiador("Pepe");
        gladiadores.add(pepe);
        Camino camino = new Camino(gladiadores);
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Fiera()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act
        gladiadores.get(0).jugarTurno(camino);
        gladiadores.get(0).jugarTurno(camino);
        gladiadores.get(0).jugarTurno(camino);


    }
}
