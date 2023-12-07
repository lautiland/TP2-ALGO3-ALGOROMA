package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;


public class InicioView {
    private static final int SPACING = 20;
    private static final String TITULO_FONT = "Gelio.ttf";
    private static final int TITULO_MB = 50;
    private static final int TITULO_FS = 120;
    private static final String BTN_FONT = "TimesNewRoman.ttf";
    private static final int BTN_WIDTH = 100;
    private static final int BTN_HEIGHT = 25;
    private static final int BTN_FS = 14;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String BACKGROUND = "/coliseo.jpg";

    private final Scene scene;
    private Button iniciar;
    private Button salida;

    public InicioView(Stage stage) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        configurarTitulo(layout);
        configurarBotones(layout);
        configurarBackground(layout, stage);

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void configurarTitulo(VBox layout) {

        Text titleText = new Text("AlgoRoma");
        VBox.setMargin(titleText, new Insets(0, 0, TITULO_MB, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream(TITULO_FONT), TITULO_FS);
        titleText.setFont(titleFont);
        titleText.setFill(Color.WHITE);

        layout.getChildren().add(titleText);
    }

    private void configurarBotones(VBox layout) {

        iniciar = new Button("Iniciar");
        iniciar.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        iniciar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");

        salida = new Button("Salir");
        salida.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        salida.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");

        Font customFont = Font.loadFont(getClass().getResourceAsStream(BTN_FONT), BTN_FS);
        iniciar.setFont(customFont);
        salida.setFont(customFont);

        layout.getChildren().addAll(iniciar, salida);
    }

    private void configurarBackground(VBox layout, Stage stage) {
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResource(BACKGROUND)).toExternalForm());
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
