package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.InicioView;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class InicioController {
    private AlgoRoma model;
    private InicioView view;

    public InicioController(AlgoRoma model, InicioView view) {
        this.model = model;
        this.view = view;

        view.getSalida().setOnAction(this::handleSalidaButton);
    }

    private void handleSalidaButton(ActionEvent event) {
        Platform.exit();
    }
}
