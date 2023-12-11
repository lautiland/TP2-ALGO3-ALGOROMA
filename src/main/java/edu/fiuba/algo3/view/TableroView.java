package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonSiguienteJugadorHandler;
import edu.fiuba.algo3.controller.BotonTirarDadosHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.tablero.Tablero;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class TableroView extends View {
    private final Scene scene;
    private final AlgoRoma juego;
    private GridPane gridPane;
    private Stage stage;
    Gladiador jugadorActual;
    private VBox layout;

    private static final Image gladiador = new Image(Objects.requireNonNull(CeldaView.class.getResource("/gladiador.png")).toExternalForm());

    public TableroView(Stage stage, AlgoRoma juego) {
        this.layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        this.stage = stage;
        this.juego = juego;
        this.jugadorActual = juego.obtenerJugadorActual();

        actualizarTablero();

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void agregarBotonDados(VBox layout) {
        Button tirarDados = new Button("Tirar dados");
        tirarDados.setOnAction(new BotonTirarDadosHandler(this.stage, juego, this));
        tirarDados.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-font-weight: bold");
        tirarDados.setPrefWidth(200);
        tirarDados.setPrefHeight(50);
        layout.getChildren().add(tirarDados);
    }

    private void configurarTablero(VBox layout, Tablero tablero) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        CeldaView celdaView = new CeldaView();
        for (int columna = 0; columna < tablero.obtenerGrilla().length; columna++) {
            for (int fila = 0; fila < tablero.obtenerGrilla()[columna].length; fila++) {
                HBox celdaVista = celdaView.generarVista(tablero.obtenerGrilla()[columna][fila]);
                gridPane.add(celdaVista, columna, fila);
            }
        }
        this.gridPane = gridPane;
        layout.getChildren().add(gridPane);
    }

    private void agregarGladiador() {
        DataClassCelda gladiadorPos = juego.obtenerTablero().obtenerPosicionDe(this.jugadorActual);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(CELL_SIZE);
        imageView.setFitHeight(CELL_SIZE);
        imageView.setImage(gladiador);

        gridPane.add(imageView, gladiadorPos.X, gladiadorPos.Y);
    }

    public void agregarBotonSiguienteJugador() {
        Button siguienteJugador = new Button("Siguiente jugador");
        siguienteJugador.setOnAction(new BotonSiguienteJugadorHandler(this.stage, juego, this));
        siguienteJugador.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-font-weight: bold");
        siguienteJugador.setPrefWidth(200);
        siguienteJugador.setPrefHeight(50);
        layout.getChildren().add(siguienteJugador);
    }

    public void actualizarMovimientos() {
        layout.getChildren().clear();
        Label jugadorLabel = new Label("Jugador actual: " + this.jugadorActual.getNombre());
        jugadorLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        layout.getChildren().add(jugadorLabel);
        configurarTablero(layout, juego.obtenerTablero());
        agregarGladiador();
        agregarBotonSiguienteJugador();
    }

    public void actualizarTablero() {
        layout.getChildren().clear();
        this.jugadorActual = juego.obtenerJugadorActual();
        Label jugadorLabel = new Label("Jugador actual: " + this.jugadorActual.getNombre());
        jugadorLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
        layout.getChildren().add(jugadorLabel);

        //configurarTituloTurno(layout, juego);
        configurarTablero(layout, juego.obtenerTablero());
        //configurarBotonTirarDados(layout, stage, juego);
        configurarBackground(layout);
        agregarGladiador();
        agregarBotonDados(layout);
    }

    public Scene getScene() {
        return scene;
    }
}
