package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Turnos;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;
import edu.fiuba.algo3.modelo.interactuable.Ninguno;
import edu.fiuba.algo3.modelo.tablero.Camino;
import edu.fiuba.algo3.modelo.tablero.Casilla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrimerEntregaTest {

    private Dado dadoMock;
    private Interactuable sinInteraccion;

    @BeforeEach
    public void setUp() {
        dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        sinInteraccion = InteractuableFactory.crearInteractuable("Ninguno");
    }

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");

        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));

        //Act
        gladiador.jugarTurno(camino);

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(0));
    }

    @Test
    public void test02JugadorSaleDeLaCasillaInicial() {
        //Arrange
        Gladiador gladiadorAtticus = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiadorAtticus));
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));

        //Act
        gladiadorAtticus.jugarTurno(camino);
        gladiadorAtticus.jugarTurno(camino);

        //Assert
        assertTrue(camino.estaEl(gladiadorAtticus, 2));
    }

    @Test
    public void test03JugadorSinEnergiaNoJuega() {
        //Arrange
        Gladiador gladiadorAtticus = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiadorAtticus));
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));

        //Act
        gladiadorAtticus.jugarTurno(camino);
        assertTrue(gladiadorAtticus.tenesPuntosDeEnegia(0));

        gladiadorAtticus.jugarTurno(camino);

        //Assert jugador no avanza, pero recibe 5 de energia por bono sin energia
        assertTrue(camino.estaEl(gladiadorAtticus, 1));
        assertTrue(gladiadorAtticus.tenesPuntosDeEnegia(5));
    }


    @Test
    public void test04RecibeComidaIncrementaEnergiaEn10() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Interactuable comida = InteractuableFactory.crearInteractuable("Comida");
        Camino camino = new Camino(List.of(gladiador));
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, comida));

        //Act
        gladiador.jugarTurno(camino);

        //Assert 20 iniciales + 10 por comer
        assertTrue(gladiador.tenesPuntosDeEnegia(30));
    }


    @Test
    public void test05gladiadorRecibeCasco() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));

        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");

        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));

        //Act
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        // Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
    }

    @Test
    public void test06gladiadorRecibeLEscudoYEspada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));

        //Act
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        // Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(18));
    }

    @Test
    public void test07gladiadorEsAtacadoYPierde15Puntos() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));

        //Act
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(5));
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arramge
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        for (int i = 0; i < 9; i++) {
            camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        }

        // Act
        for (int i = 0; i < 8; i++) {
            gladiador.jugarTurno(camino);
        }

        //Assert, sube 5 puntos de los 20 iniciales
        assertTrue(gladiador.tenesPuntosDeEnegia(25));
    }

    @Test
    public void test09GladiadorLlegaAMetaSinLlaveRetroceAMitadDeCamino() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));
        camino.agregarCasilla(new Casilla(new Ninguno(), new Ninguno()));

        //Act gladiador se mueve hasta el fin
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        //Assert el jugador vuelve a mitad de camino
        assertTrue(camino.estaEl(gladiador, 1));
    }

    @Test
    public void test10gladiadorEsAtacadoYNoRecibeDanioPorPoseerTodoElEquipo() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");
        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));

        //Act
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
    }

    @Test
    public void test11gladiadorTieneLlaveYRecibeOtroPremioNoCambiaNada() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        Interactuable premio = InteractuableFactory.crearInteractuable("Equipamiento");
        Interactuable fiera = InteractuableFactory.crearInteractuable("Fiera");

        camino.agregarCasilla(new Casilla(sinInteraccion, sinInteraccion));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, premio));
        camino.agregarCasilla(new Casilla(sinInteraccion, fiera));


        //Act
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino); // Consigue llave
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);


        //Assert
        assertTrue(gladiador.tenesPuntosDeEnegia(20));
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
