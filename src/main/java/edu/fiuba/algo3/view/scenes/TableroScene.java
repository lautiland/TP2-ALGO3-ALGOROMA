package edu.fiuba.algo3.view.scenes;

import edu.fiuba.algo3.controller.BotonSiguienteJugadorHandler;
import edu.fiuba.algo3.controller.BotonTirarDadosHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.modelview.Camino;
import edu.fiuba.algo3.view.modelview.Gladiador;
import edu.fiuba.algo3.view.modelview.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class TableroScene extends SceneUtil {
    private final Stage STAGE;
    private final Scene SCENE;
    private final BorderPane LAYOUT = new BorderPane();
    private final AlgoRoma JUEGO;
    private GridPane grillaTablero;
    private final Camino CAMINO;
    private final edu.fiuba.algo3.view.modelview.Tablero TABLERO;

    private final Gladiador observadorGladiador;

    public TableroScene(Stage stage, AlgoRoma juego, Camino camino, Gladiador observadorGladiador) {
        this.STAGE = stage;
        this.observadorGladiador = observadorGladiador;
        this.JUEGO = juego;
        this.CAMINO = camino;
        this.TABLERO = new Tablero(juego.getMapa());

        configurarBackground();
        this.grillaTablero = TABLERO.paint();
        CAMINO.paint(grillaTablero);
        LAYOUT.setCenter(grillaTablero);
        actualizarSiguienteTurno();

        SCENE = new Scene(LAYOUT, WIDTH, HEIGHT);
    }

    private void agregarBotonDados() {
        LAYOUT.setBottom(null);
        VBox subGrilla = new VBox();
        subGrilla.setAlignment(Pos.CENTER);
        Button tirarDados = new Button("Tirar dados");
        tirarDados.setOnAction(new BotonTirarDadosHandler(STAGE, JUEGO, this));
        configurarBoton(tirarDados);
        subGrilla.getChildren().add(tirarDados);
        subGrilla.setPadding(new Insets(0, 0, CELL_SIZE, 0));
        LAYOUT.setBottom(subGrilla);
    }

    public void agregarBotonSiguienteJugador() {
        LAYOUT.setBottom(null);
        VBox subGrilla = new VBox();
        subGrilla.setAlignment(Pos.CENTER);
        Button siguienteJugador = new Button("Siguiente");
        siguienteJugador.setOnAction(new BotonSiguienteJugadorHandler(this));
        configurarBoton(siguienteJugador);
        subGrilla.getChildren().add(siguienteJugador);
        subGrilla.setPadding(new Insets(0, 0, CELL_SIZE, 0));
        LAYOUT.setBottom(subGrilla);
    }

    public void actualizarMovimientos() {
        configurarGrillaInfo();
        LAYOUT.setCenter(null);
        this.grillaTablero = TABLERO.paint();
        CAMINO.paint(grillaTablero);
        LAYOUT.setCenter(grillaTablero);
        agregarBotonSiguienteJugador();
    }

    public void actualizarSiguienteTurno() {
        configurarGrillaInfo();
        agregarBotonDados();
    }

    private void configurarGrillaInfo() {
        observadorGladiador.paint(LAYOUT);
    }

    private void configurarBackground() {
        Image pasto_tile = new Image(Objects.requireNonNull(SceneUtil.class.getResource("/tile/pasto_tile.png")).toExternalForm());
        ImageView backgroundImageView = new ImageView(pasto_tile);
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setSmooth(true); // Opcional: hace que el escalado sea más suave
        backgroundImageView.setCache(true); // Opcional: mejora el rendimiento
        BackgroundSize backgroundSize = new BackgroundSize(CELL_SIZE, CELL_SIZE, false, false, false, false);
        LAYOUT.setBackground(new Background(new BackgroundImage(backgroundImageView.getImage(), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize)));
    }

    public Scene getScene() {
        return SCENE;
    }

}
