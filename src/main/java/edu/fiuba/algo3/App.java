package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.InicioController;
import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.InicioView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoRoma");
        stage.setMaximized(true);

        AlgoRoma model = new AlgoRoma();
        InicioView inicio = new InicioView();
        InicioController controller = new InicioController(model, inicio);

        stage.setScene(inicio.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}