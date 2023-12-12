package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSiguienteJugadorHandler implements EventHandler<ActionEvent> {
    private final TableroView tableroView;

    public BotonSiguienteJugadorHandler(TableroView tableroView) {
        this.tableroView = tableroView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tableroView.actualizarTablero();
    }
}
