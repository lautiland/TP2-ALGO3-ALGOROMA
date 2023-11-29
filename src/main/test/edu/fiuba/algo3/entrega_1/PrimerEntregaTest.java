package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Turnos;
import edu.fiuba.algo3.modelo.equipamiento.*;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;
import edu.fiuba.algo3.modelo.interactuable.Ninguno;
import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimerEntregaTest {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
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
        Gladiador gladiadorAtticus = new Gladiador("Atticus", new Dado());
        gladiadores.add(gladiadorAtticus);
        Camino camino = new Camino(gladiadores);
        Interactuable premio = InteractuableFactory.crearInteractuable("Comida");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable("Lesion");
        camino.agregarCasilla(new Casilla(premio, obstaculo));
        camino.agregarCasilla(new Casilla(premio, obstaculo));
        camino.agregarCasilla(new Casilla(premio, obstaculo));

        //Act
        camino.mover(gladiadorAtticus, 2);

        //Assert
        assertTrue(camino.estaEl(gladiadorAtticus, 2));
    }

    @Test
    public void test03JugadorSinEnergiaNoJuega() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiadorAtticus = new Gladiador("Atticus", new Dado());
        gladiadores.add(gladiadorAtticus);
        Camino camino = new Camino(gladiadores);
        Interactuable premio = InteractuableFactory.crearInteractuable("Ninguno");
        Interactuable obstaculo = InteractuableFactory.crearInteractuable("Fiera");
        for (int celda = 1; celda <= 30; celda++) {
            camino.agregarCasilla(new Casilla(premio, obstaculo));
        }

        //Act
        gladiadorAtticus.jugarTurno(camino);
        assertTrue(gladiadorAtticus.tenesPuntosDeEnegia(0));

        gladiadorAtticus.jugarTurno(camino);

        //Assert jugador no avanza, pero recibe 5 de energia por bono sin energia
        assertTrue(gladiadorAtticus.tenesPuntosDeEnegia(5));
    }


    @Test
    public void test04RecibeComidaIncrementaEnergiaEn10() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
        Interactuable comida = InteractuableFactory.crearInteractuable("Comida");

        //Act
        comida.interactuarCon(gladiador);

        //Assert 20 iniciales + 10 por comer
        assertTrue(gladiador.tenesPuntosDeEnegia(30));
    }


    @Test
    public void test05gladiadorRecibeCasco() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
        Casco casco = new Casco();
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");

        //Act
        premio.interactuarCon(gladiador);

        // Assert
        assertTrue(gladiador.tenesEsteEquipo(casco));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");

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
        Gladiador gladiador = new Gladiador("Atticus", new Dado());

        //Act
        gladiador.actualizarEquipo();
        gladiador.recibirAtaque();

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arramge
        Gladiador gladiador = new Gladiador("Atticus", new Dado());

        // Act
        for (int turno = 1; turno <= 8; turno++) {
            gladiador.actualizarSeniority();
        }

        gladiador.actualizarSeniority();

        //Assert, sube 5 puntos de los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(25));
    }

    @Test
    public void test09GladiadorLlegaAMetaSinLlaveRetroceAMitadDeCamino() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
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
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
        Interactuable obstaculo = InteractuableFactory.crearInteractuable("Fiera");

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
        Gladiador gladiador = new Gladiador("Atticus", new Dado());
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
}
