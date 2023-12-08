package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JugadoresView extends VBox {

    public JugadoresView(Stage stage, int cantidadJugdores) {
        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(30));
        this.setStyle("-fx-background-color: #000000;");

        Label titulo = new Label("Elige a los jugadores");
        titulo.setFont(Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 30));
        titulo.setPadding(new Insets(10, 0, 15, 0));
        titulo.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: #ffffff");
        this.getChildren().add(titulo);

        for (int i = 0; i < cantidadJugdores; i++) {
            Label jugador = new Label("Jugador " + (i + 1));
            jugador.setFont(Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 20));
            jugador.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center; -fx-text-fill: #ffffff");

            TextField nombre = new TextField();
            nombre.setFont(Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 15));
            nombre.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center");
            nombre.setPromptText("Nombre");
            nombre.setMaxWidth(200);

            this.getChildren().addAll(jugador, nombre);
        }

        Button boton = new Button("Comenzar");
        boton.setFont(Font.loadFont(getClass().getResourceAsStream("/TimesNewRoman.ttf"), 15));
        boton.setStyle("-fx-background-radius: 5; -fx-font-weight: bold; -fx-alignment: center");

        this.getChildren().add(boton);
    }
}
