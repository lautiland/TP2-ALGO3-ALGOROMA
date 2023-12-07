package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

import java.util.Objects;


public class InicioView {
    private final Scene scene;
    private Button iniciar;
    private Button salida;

    public InicioView(Stage stage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        configurarTitulo(layout);
        configurarBotones(layout);
        configurarBackground(layout, stage);

        scene = new Scene(layout, 800, 600);
    }

    private void configurarTitulo(VBox layout) {

        Text titleText = new Text("AlgoRoma");
        VBox.setMargin(titleText, new Insets(0, 0, 50, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream("/Gelio.ttf"), 120);
        titleText.setFont(titleFont);
        titleText.setFill(Color.WHITE);

        layout.getChildren().add(titleText);
    }

    private void configurarBotones(VBox layout) {

        iniciar = new Button("Iniciar");
        iniciar.setPrefSize(100, 25);
        iniciar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");

        salida = new Button("Salir");
        salida.setPrefSize(100, 25);
        salida.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");

        Font customFont = Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 14);
        iniciar.setFont(customFont);
        salida.setFont(customFont);

        layout.getChildren().addAll(iniciar, salida);
    }

    private void configurarBackground(VBox layout, Stage stage) {
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResource("/coliseo.jpg")).toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true); // Opcional: hace que el escalado sea más suave
        backgroundImageView.setCache(true); // Opcional: mejora el rendimiento
        backgroundImageView.setFitWidth(stage.getWidth());
        backgroundImageView.setFitHeight(stage.getHeight());

        layout.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    public Scene getScene() {
        return scene;
    }

    public Button getSalida() {
        return salida;
    }

    public Button getIniciar() {
        return iniciar;
    }
}
