package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerEntregaTest {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){
        Energia energiaInicial = new Energia(20);
        Gladiador gladiador = new Gladiador("Juan",energiaInicial, new Posicion(0,0));

        assertEquals(20, energiaInicial.obtenerPuntos());
        assertTrue(gladiador.obtenerEquipamiento().isEmpty());
    }

    @Test
    public void test02JugadorSaleDeLaCasillaInicial(){
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(0,0);
        Gladiador gladiador = new Gladiador("Juan",new Energia(20), posicionInicial);

       tablero.avanzar(gladiador, new Dado());

        assertNotEquals(gladiador.obtenerPosicion(), posicionInicial);
    }

}
