package edu.fiuba.algo3.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.util.Objects;

public class View {
    protected static final int SPACING = 20;
    protected static final String TITULO_PRINCIPAL_FONT = "/Gelio.ttf";
    protected static final int TITULO_PRINCIPAL_FS = 120;
    protected static final int TITULO_FS = 30;
    protected static final String TXT_FONT = "/TimesNewRoman.ttf";
    protected static final int TXT_FS = 20;
    protected static final int BTN_WIDTH = 100;
    protected static final int BTN_HEIGHT = 25;
    protected static final int BTN_FS = 14;
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;
    protected static final String BACKGROUND = "/coliseo.jpg";

    protected void configurarBackground(VBox layout) {
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResource(BACKGROUND)).toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true); // Opcional: hace que el escalado sea más suave
        backgroundImageView.setCache(true); // Opcional: mejora el rendimiento
        backgroundImageView.setFitWidth(WIDTH);
        backgroundImageView.setFitHeight(HEIGHT);

        layout.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    protected void configurarBoton(Button button) {
        button.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");
        Font customFont = Font.loadFont(getClass().getResourceAsStream(TXT_FONT), BTN_FS);
        button.setFont(customFont);
    }

    protected void configurarTitulo(Label texto, String fuente, int fontSize) {
        texto.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fuente), fontSize);
        texto.setFont(customFont);
    }
}