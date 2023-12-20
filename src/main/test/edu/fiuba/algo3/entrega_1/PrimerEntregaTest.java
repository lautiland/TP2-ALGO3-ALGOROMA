package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Turnos;
import edu.fiuba.algo3.model.excepciones.SinTurnos;
import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.interactuable.Llegada;
import edu.fiuba.algo3.model.interactuable.SinInteraccion;
import edu.fiuba.algo3.model.tablero.Camino;
import edu.fiuba.algo3.model.tablero.Casilla;
import edu.fiuba.algo3.model.tablero.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PrimerEntregaTest {
    private static final int PUNTOS_DESPUES_COMER = 30;
    private static final int PUNTOS_ATAQUE_FIERA_ESCUDO_ESPADA = 18;
    private static final int PUNTOS_DESPUES_BONUS_SEMISENIOR = 25;
    private static final int PUNTOS_ENERGIA_INICIALES = 20;
    private static final int TURNOS_MAXIMOS = 30;
    private Dado dadoMock;
    private Interactuable sinInteraccion;
    private static Logger loggerMock;

    @BeforeEach
    public void beforeEach() {
        dadoMock = mock(Dado.class);
        when(dadoMock.tirar()).thenReturn(1);
        sinInteraccion = InteractuableFactory.crearInteractuable("Ninguno");
        loggerMock = mock(Logger.class);
        new Logger(loggerMock);
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
        verify(loggerMock).info("El gladiador ahora tiene 0 puntos de energía");
        assertEquals(gladiador.obtenerPuntosEnergia(), 0);
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
        verify(loggerMock, atLeastOnce()).info("Gladiador Atticus tira el dado, avanza 1 casillas");
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
        assertEquals(gladiadorAtticus.obtenerPuntosEnergia(), 0);

        gladiadorAtticus.jugarTurno(camino);

        //Assert jugador no avanza, pero recibe 5 de energia por bono sin energia
        verify(loggerMock).info("El gladiador Atticus no avanza, esta sin energia, recibe bono de 5 puntos");
        verify(loggerMock).info("El gladiador ahora tiene 5 puntos de energía");
        assertTrue(camino.estaEl(gladiadorAtticus, 1));
        assertEquals(gladiadorAtticus.obtenerPuntosEnergia(), 5);
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
        verify(loggerMock).info("El gladiador Atticus encontró un rico pan, ganas 10 puntos");
        verify(loggerMock).info("El gladiador ahora tiene 30 puntos de energía");
        assertEquals(gladiador.obtenerPuntosEnergia(), PUNTOS_DESPUES_COMER);
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
        verify(loggerMock).info("El gladiador recibe casco");
        assertEquals(gladiador.obtenerPuntosEnergia(), 5);
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
        verify(loggerMock).info("El gladiador recibe un escudo y una espada");
        assertEquals(gladiador.obtenerPuntosEnergia(), PUNTOS_ATAQUE_FIERA_ESCUDO_ESPADA);
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
        verify(loggerMock).info("El gladiador Atticus encontró una fiera");
        verify(loggerMock).info("El gladiador Atticus tiene un casco, pierde 15 puntos de energia");
        assertEquals(gladiador.obtenerPuntosEnergia(), 5);
    }

    @Test
    public void test08gladiadorSubeASemiSeniorDespuesDe8TurnosEIncrementaSuEnergia() {
        // Arrange
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
        verify(loggerMock).info("El gladiador Atticus subió de nivel a SemiSenior");
        verify(loggerMock).info("El gladiador Atticus consigue 5 puntos de energia por ser SemiSenior");
        assertEquals(gladiador.obtenerPuntosEnergia(), PUNTOS_DESPUES_BONUS_SEMISENIOR);

    }

    @Test
    public void test09GladiadorLlegaAMetaSinLlaveRetroceAMitadDeCamino() {
        //Arrange
        Gladiador gladiador = new Gladiador("Atticus", dadoMock);
        Camino camino = new Camino(List.of(gladiador));
        camino.agregarCasilla(new Casilla(new SinInteraccion(), new SinInteraccion()));
        camino.agregarCasilla(new Casilla(new SinInteraccion(), new SinInteraccion()));
        camino.agregarCasilla(new Casilla(new Llegada(), new SinInteraccion()));

        //Act gladiador se mueve hasta el fin
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);
        gladiador.jugarTurno(camino);

        //Assert el jugador vuelve a mitad de camino
        verify(loggerMock, atLeastOnce()).info("El gladiador Atticus llegó a la meta");
        verify(loggerMock, atLeastOnce()).info("El gladiador Atticus no tiene llave, vuelve a mitad de camino");
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
        verify(loggerMock).info("El gladiador recibe una llave");
        verify(loggerMock).info("El gladiador Atticus tiene la llave, no pierde energia");
        assertEquals(gladiador.obtenerPuntosEnergia(), PUNTOS_ENERGIA_INICIALES);
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
        verify(loggerMock).info("El gladiador recibe una llave");
        verify(loggerMock).info("El gladiador cayo en una casilla de mejora pero ya esta al máximo");
        assertEquals(gladiador.obtenerPuntosEnergia(), PUNTOS_ENERGIA_INICIALES);

    }

    @Test
    public void test12SiNadieGanaDespuesDe30RondasFinalizaElJuego() {
        //Arrange
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        Turnos turnos = new Turnos(gladiadores);
        Tablero tableroMock = mock(Tablero.class);

        // Act y Assert
        for (int i = 1; i < TURNOS_MAXIMOS; i++) {
            // Realizar la ejecución del método 30 veces
            turnos.ejecutar(gladiadores, tableroMock);
        }

        // Verificar que la excepción se lanza en la ejecución 30
        assertThrows(SinTurnos.class, () -> turnos.ejecutar(gladiadores, tableroMock));
        verify(loggerMock).error("Se han acabado los turnos, no hay ganador");
    }
}
