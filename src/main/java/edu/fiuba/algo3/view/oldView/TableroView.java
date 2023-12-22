package edu.fiuba.algo3.view.oldView;

import edu.fiuba.algo3.controller.BotonSiguienteJugadorHandler;
import edu.fiuba.algo3.controller.BotonTirarDadosHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.view.newView.Camino;
import edu.fiuba.algo3.view.newView.Tablero;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.util.Objects;

public class TableroView extends View {
    private final Stage STAGE;
    private final Scene SCENE;
    private final BorderPane LAYOUT = new BorderPane();
    private final AlgoRoma JUEGO;
    private final HBox grillaInfo = new HBox();
    private GridPane grillaTablero;
    private Gladiador jugadorActual;
    private final Camino CAMINO;
    private final edu.fiuba.algo3.view.newView.Tablero TABLERO;

    public TableroView(Stage stage, AlgoRoma juego, Camino camino) {
        this.STAGE = stage;
        this.grillaInfo.setAlignment(Pos.CENTER);
        this.JUEGO = juego;
        this.jugadorActual = juego.obtenerJugadorActual();
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
        this.jugadorActual = JUEGO.obtenerJugadorActual();
        configurarGrillaInfo();
        agregarBotonDados();
    }

    private void configurarGrillaInfo() {
        LAYOUT.setTop(null);
        grillaInfo.getChildren().clear();
        grillaInfo.setAlignment(Pos.CENTER);
        VBox subGrilla = new VBox(SPACING);
        subGrilla.setPadding(new Insets(0 , 2 * CELL_SIZE, 0, 0));
        subGrilla.setAlignment(Pos.CENTER);

        Label jugadorLabel = new Label(this.jugadorActual.getNombre());
        Label energiaLabel = new Label("Energía: " + this.jugadorActual.obtenerPuntosEnergia());
        configurarTitulo(jugadorLabel, TITULO_PRINCIPAL_FONT, TITULO_FS);
        configurarTitulo(energiaLabel, TXT_FONT, TITULO_FS);
        String nombreEquipamiento = this.jugadorActual.getEquipamiento().getClass().getSimpleName().toLowerCase();
        //TODO: ver si se puede hacer esto de otra forma con el observer de equipamiento
        Image imagenEquip = new Image(Objects.requireNonNull(View.class.getResource("/equipamiento/" + nombreEquipamiento + ".png")).toExternalForm());
        ImageView imageViewEquip = new ImageView(imagenEquip);
        imageViewEquip.setFitHeight(CELL_SIZE);
        imageViewEquip.setFitWidth(CELL_SIZE);

        subGrilla.getChildren().addAll(jugadorLabel, energiaLabel);
        grillaInfo.getChildren().add(subGrilla);
        grillaInfo.getChildren().addAll(imageViewEquip);
        grillaInfo.setPadding(new Insets(CELL_SIZE, 0, 0, 0));
        LAYOUT.setTop(grillaInfo);
    }

    private void configurarBackground() {
        Image pasto_tile = new Image(Objects.requireNonNull(View.class.getResource("/tile/pasto_tile.png")).toExternalForm());
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
