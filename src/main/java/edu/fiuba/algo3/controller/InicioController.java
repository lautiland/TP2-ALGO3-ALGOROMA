package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.InicioView;
import edu.fiuba.algo3.view.SeleccionView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class InicioController {
    private final Stage stage;
    private InicioView view;

    public InicioController(InicioView view, Stage stage) {
        this.stage = stage;
        this.view = view;

        view.getIniciar().setOnAction(this::handleIniciarButton);
        view.getSalida().setOnAction(this::handleSalidaButton);
    }

    private void handleSalidaButton(ActionEvent event) {
        Platform.exit();
    }

    private void handleIniciarButton(ActionEvent event) {
        SeleccionView seleccion = new SeleccionView(this.stage);
        SeleccionController controller = new SeleccionController(seleccion, this.stage);

        this.stage.setScene(seleccion.getScene());
        this.stage.show();
    }
}
