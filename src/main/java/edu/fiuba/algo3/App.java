package edu.fiuba.algo3;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.InicioView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoRoma");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/icono.png")).toExternalForm());
        stage.getIcons().add(icon);

        AlgoRoma algoRoma = new AlgoRoma();
        InicioView inicio = new InicioView(stage, algoRoma);

        stage.setScene(inicio.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}