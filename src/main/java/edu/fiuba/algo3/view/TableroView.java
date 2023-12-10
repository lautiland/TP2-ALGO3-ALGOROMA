package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.tablero.Tablero;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

    public TableroView(Stage stage, AlgoRoma juego) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        this.juego = juego;

        //configurarTituloTurno(layout, juego);
        configurarTablero(layout, juego.obtenerTablero());
        //configurarBotonTirarDados(layout, stage, juego);
        configurarBackground(layout);

        agregarGladiador();

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void configurarTablero(VBox layout, Tablero tablero) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        for (int columna = 0; columna < tablero.obtenerGrilla().length; columna++) {
            for (int fila = 0; fila < tablero.obtenerGrilla()[columna].length; fila++) {
                HBox celdaVista = CeldaView.generarVista(tablero.obtenerGrilla()[columna][fila]);
                gridPane.add(celdaVista, columna, fila);
            }
        }
        this.gridPane = gridPane;
        layout.getChildren().add(gridPane);
    }

    private void agregarGladiador() {
        DataClassCelda salida = juego.obtenerTablero().obtenerSalida();

        ImageView imageView = new ImageView();
        imageView.setFitWidth(CELL_SIZE);
        imageView.setFitHeight(CELL_SIZE);
        imageView.setImage(new Image(Objects.requireNonNull(CeldaView.class.getResource("/gladiador.png")).toExternalForm()));

        gridPane.add(imageView, salida.X, salida.Y);
    }

    public Scene getScene() {
        return scene;
    }
}
