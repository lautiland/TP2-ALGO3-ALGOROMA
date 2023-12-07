package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SeleccionView {
    private static final int SPACING = 20;
    private final Scene scene;
    private Button salida;

    public SeleccionView(Stage stage) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        Text ejemplo = new Text("Acá va la interfaz de la creación de jugadores");
        VBox.setMargin(ejemplo, new Insets(0, 0, 50, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 14);
        ejemplo.setFont(titleFont);
        ejemplo.setFill(Color.BLACK);
        layout.getChildren().add(ejemplo);


        //acá va el código de la vista de selección de jugadores (configuración de botones, background, etc)

        scene = new Scene(layout, 800, 600);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getSalida() {
        return salida;
    }
}
