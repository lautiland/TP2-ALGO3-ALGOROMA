package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.SeleccionView;
import javafx.stage.Stage;

public class SeleccionController {
    private final Stage stage;
    private final SeleccionView view;

    public SeleccionController(SeleccionView view, Stage stage) {
        this.stage = stage;
        this.view = view;

        AlgoRoma modelo = new AlgoRoma();

    }
}
