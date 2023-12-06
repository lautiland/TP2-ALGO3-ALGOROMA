package edu.fiuba.algo3.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class InicioView {
    private Scene scene;
    private Button salida;

    public InicioView() {
        Button start = new Button("Iniciar");
        salida = new Button("Salir");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(start, salida);

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getSalida() {
        return salida;
    }
}
