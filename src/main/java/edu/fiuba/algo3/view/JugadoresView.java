package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonIniciarTableroHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JugadoresView extends View {

    private final Scene scene;
    private final ArrayList<TextField> inputs = new ArrayList<>();
    private final AlgoRoma juego;

    public JugadoresView(Stage stage, int cantidadJugdores, AlgoRoma juego) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        this.juego = juego;
        configurarTitulo(layout);
        configurarInputs(layout, cantidadJugdores);
        configurarBotonComenzar(layout, stage);
        configurarBackground(layout);

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void configurarTitulo(VBox layout) {
        Label titulo = new Label("Elige a los jugadores");
        configurarTitulo(titulo, TXT_FONT, TITULO_FS);
        layout.getChildren().add(titulo);
    }

    private void configurarInputs(VBox layout, int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Label jugador = new Label("Gladiador " + (i + 1));
            configurarTitulo(jugador, TXT_FONT, TXT_FS);

            TextField nombre = new TextField();
            configurarTextField(nombre);
            inputs.add(nombre);

            HBox inputContainer = new HBox(SPACING);
            inputContainer.setAlignment(Pos.CENTER);
            inputContainer.getChildren().addAll(jugador, nombre);

            layout.getChildren().add(inputContainer);
        }
    }

    private void configurarTextField(TextField textField) {
        textField.setFont(Font.loadFont(getClass().getResourceAsStream(TXT_FONT), BTN_FS));
        textField.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center");
        textField.setPromptText("Nombre");
        textField.setMaxWidth(150);
        textField.setMaxHeight(BTN_HEIGHT);
    }

    private void configurarBotonComenzar(VBox layout, Stage stage) {
        Button comenzar = new Button("Comenzar");
        configurarBoton(comenzar);
        comenzar.setOnAction(new BotonIniciarTableroHandler(inputs, stage, juego));

        layout.getChildren().add(comenzar);
    }

    public Scene getScene() {
        return scene;
    }
}
