package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonComenzarHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final AlgoRoma juego;
    private final ArrayList<TextField> inputs;

    public BotonComenzarHandler(ArrayList<TextField> inputs, Stage stage, AlgoRoma juego) {
        this.stage = stage;
        this.juego = juego;
        this.inputs = inputs;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (TextField input : inputs) {
            String nombre = input.getText();
        }
    }
}
