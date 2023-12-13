package edu.fiuba.algo3.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class View {
    protected static final int SPACING = 20;
    protected static final String TITULO_PRINCIPAL_FONT = "/Gelio.ttf";
    protected static final int TITULO_PRINCIPAL_FS = 120;
    protected static final int TITULO_FS = 30;
    protected static final String TXT_FONT = "/TimesNewRoman.ttf";
    protected static final int TXT_FS = 20;
    protected static final int BTN_WIDTH = 120;
    protected static final int BTN_HEIGHT = 25;
    protected static final int BTN_FS = 14;
    protected static final int CELL_SIZE = 50;
    protected static double WIDTH;
    protected static double HEIGHT;
    protected static final Image BACKGROUND = new Image(Objects.requireNonNull(View.class.getResource("/coliseo.jpg")).toExternalForm());

    protected void configurarBackground(VBox layout) {
        ImageView backgroundImageView = new ImageView(BACKGROUND);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true); // Opcional: hace que el escalado sea más suave
        backgroundImageView.setCache(true); // Opcional: mejora el rendimiento
        backgroundImageView.setFitWidth(WIDTH);
        backgroundImageView.setFitHeight(HEIGHT);

        layout.setBackground(new Background(new BackgroundImage(BACKGROUND, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    protected void configurarBoton(Button button) {
        button.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #BDD9F2; -fx-text-fill: black; -fx-padding: 8 16"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16"));
        Font customFont = Font.font(TXT_FONT, FontWeight.BOLD, BTN_FS);
        button.setFont(customFont);
    }

    protected void configurarTitulo(Label texto, String fuente, int fontSize) {
        texto.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        Font customFont = Font.loadFont(getClass().getResourceAsStream(fuente), fontSize);
        texto.setFont(customFont);
    }

    public static void setDimensions(double width, double height) {
        WIDTH = width;
        HEIGHT = height;
    }
}
