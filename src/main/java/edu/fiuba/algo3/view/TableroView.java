package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.tablero.Tablero;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class TableroView extends View{
    private final Scene scene;
    private final AlgoRoma juego;

    public TableroView(Stage stage, AlgoRoma juego) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        //configurarTituloTurno(layout, juego);
        configurarTablero(layout, juego.obtenerTablero());
        //configurarBotonTirarDados(layout, stage, juego);
        configurarBackground(layout);

        this.juego = juego;

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
        layout.getChildren().add(gridPane);
    }

    public Scene getScene() {
        return scene;
    }
}
