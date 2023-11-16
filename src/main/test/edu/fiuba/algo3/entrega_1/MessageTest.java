package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void jugadorEmpiezaConLaEnergiaYEquipamientoCorrespondiente() {
        NivelFactory nivel = new NivelFactory();
        Nivel novato = nivel.obtenerInstancia("NOVATO");


    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
}
