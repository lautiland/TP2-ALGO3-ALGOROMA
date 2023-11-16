package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerEntregaTest {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){
        Energia energiaInicial = new Energia(20);
        Gladiador gladiador = new Gladiador("Juan",energiaInicial);

        assertEquals(20, energiaInicial.obtenerPuntos());
        assertTrue(gladiador.obtenerEquipamiento().isEmpty());
    }

    @Test
    public void test02JugadorSaleDeLaCasillaInicial(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador("Juan",new Energia(20));
        ArrayList<Gladiador> gladiadores = new ArrayList<Gladiador>();
        gladiadores.add(gladiador);
        Tablero tablero = new Tablero(gladiadores, new ArrayList<Fiera>());

       tablero.avanzar(gladiador, new Dado());

        assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }

    @Test
    public void test03NoPuedeJugarUnTurnoSinEnergia(){
        Posicion posicionInicial = new Posicion(0);
        Gladiador gladiador = new Gladiador("Juan",new Energia(20));
        ArrayList<Gladiador> gladiadores = new ArrayList<Gladiador>();
        gladiadores.add(gladiador);
        Tablero tablero = new Tablero(gladiadores, new ArrayList<Fiera>(new Fiera()));

        tablero.avanzar(gladiador, new Dado());

        assertNotEquals(tablero.obtenerPosicionGladiador(gladiador), posicionInicial);
    }

}
