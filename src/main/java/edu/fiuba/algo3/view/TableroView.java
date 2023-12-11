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
import javafx.scene.layout.*;
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
        configurarBoton(tirarDados);
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
        Button siguienteJugador = new Button("Siguiente");
        siguienteJugador.setOnAction(new BotonSiguienteJugadorHandler(this.stage, juego, this));
        configurarBoton(siguienteJugador);
        layout.getChildren().add(siguienteJugador);
    }

    public void actualizarMovimientos() {
        layout.getChildren().clear();
        Label jugadorLabel = new Label("Jugador actual: " + this.jugadorActual.getNombre());
        configurarTitulo(jugadorLabel, TXT_FONT, TITULO_FS);
        layout.getChildren().add(jugadorLabel);
        configurarTablero(layout, juego.obtenerTablero());
        agregarGladiador();
        agregarBotonSiguienteJugador();
    }

    public void actualizarTablero() {
        layout.getChildren().clear();
        this.jugadorActual = juego.obtenerJugadorActual();
        Label jugadorLabel = new Label("Jugador actual: " + this.jugadorActual.getNombre());
        configurarTitulo(jugadorLabel, TXT_FONT, TITULO_FS);
        layout.getChildren().add(jugadorLabel);

        configurarTablero(layout, juego.obtenerTablero());
        //configurarBotonTirarDados(layout, stage, juego);
        configurarBackground();
        agregarGladiador();
        agregarBotonDados(layout);
    }

    private void configurarBackground() {
        Image pasto_tile = new Image(Objects.requireNonNull(View.class.getResource("/pasto_tile.png")).toExternalForm());
        ImageView backgroundImageView = new ImageView(pasto_tile);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true); // Opcional: hace que el escalado sea más suave
        backgroundImageView.setCache(true); // Opcional: mejora el rendimiento
        BackgroundSize backgroundSize = new BackgroundSize(CELL_SIZE, CELL_SIZE, false, false, false, false);
        layout.setBackground(new Background(new BackgroundImage(backgroundImageView.getImage(), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }

    public Scene getScene() {
        return scene;
    }
}
