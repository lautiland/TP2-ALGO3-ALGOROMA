package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BotonIniciarTableroHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final ArrayList<TextField> inputs;
    private final AlgoRoma juego;
    private final Button boton;

    public BotonIniciarTableroHandler(Button boton, ArrayList<TextField> inputs, Stage stage, AlgoRoma juego) {
        this.boton = boton;
        this.stage = stage;
        this.inputs = inputs;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boton.setDisable(true);
        for (TextField input : inputs) {
            String nombre = input.getText();
            juego.agregarGladiador(nombre);
        }
        try {
            juego.iniciarJuegoCompleto("mapa.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TableroView tablero = new TableroView(stage, juego);
        stage.setScene(tablero.getScene());
    }
}
