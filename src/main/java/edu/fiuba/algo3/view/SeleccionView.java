package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonCantidadJugadorHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static edu.fiuba.algo3.view.View.BTN_FS;
import static javafx.scene.paint.Color.BLACK;

public class SeleccionView extends VBox {
    private final AlgoRoma juego;

    public SeleccionView(Stage stage, AlgoRoma juego) {
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(BLACK, null, null)));

        configurarContenido(stage);
        this.juego = juego;
    }

    public void configurarContenido(Stage stage) {
        VBox contenido = new VBox(20);
        contenido.setAlignment(Pos.CENTER);

        configurarTexto(contenido);
        configurarBotones(contenido, stage);

        this.getChildren().add(contenido);
    }

    public void configurarTexto(VBox layout) {
        Text texto = new Text("Seleccione la cantidad de jugadores");
        VBox.setMargin(texto, new Insets(0, 0, 10, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream("./TimesNewRoman.ttf"), 25);
        texto.setFont(titleFont);
        texto.setFill(Color.WHITE);
        //agrego sombra al texto para mejor visibilidad
        DropShadow sombra = new DropShadow();
        sombra.setColor(BLACK);
        sombra.setRadius(9);
        sombra.setOffsetX(3);
        sombra.setOffsetY(3);
        texto.setEffect(sombra);
        layout.getChildren().add(texto);
    }

    public void configurarBotones(VBox layout, Stage stage) {

        HBox botonesBox = new HBox(20);
        botonesBox.setAlignment(Pos.CENTER);

        for (int i = 2; i <= 6; i++) {
            ToggleButton boton = new ToggleButton(Integer.toString(i));
            boton.setPrefSize(100, 25);
            boton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-padding: 8 16;");
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), BTN_FS);
            boton.setFont(customFont);
            botonesBox.getChildren().add(boton);
            boton.setOnAction(new BotonCantidadJugadorHandler(stage, i));
        }

        layout.getChildren().add(botonesBox);
    }
}
