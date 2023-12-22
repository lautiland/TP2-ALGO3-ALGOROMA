package edu.fiuba.algo3.view.newView;

import edu.fiuba.algo3.model.parser.DataClassCelda;
import edu.fiuba.algo3.model.parser.DataClassTablero;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Tablero {
    private final Celda[][] GRILLA;
    public Tablero(DataClassTablero mapa) {
        this.GRILLA = new Celda[mapa.LARGO][mapa.ANCHO];
        agregarFondoCamino(mapa);
        agregarCamino(mapa);
    }
    private void agregarCamino(DataClassTablero mapa) {
        for (DataClassCelda celdaCamino : mapa.getCeldas()) {
            Obstaculo obstaculo = new Obstaculo(celdaCamino.OBSTACULO);
            Premio premio = new Premio(celdaCamino.PREMIO);
            GRILLA[celdaCamino.X][celdaCamino.Y] = new Casilla(celdaCamino.TIPO, obstaculo, premio);
        }
    }
    private void agregarFondoCamino(DataClassTablero mapa) {
        for (int columna = 0; columna < mapa.ANCHO; columna++) {
            for (int fila = 0; fila < mapa.LARGO; fila++) {
                GRILLA[fila][columna] = new Casilla();
            }
        }
    }
    public GridPane paint(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        for (int columna = 0; columna < GRILLA[0].length; columna++) {
            for (int fila = 0; fila < GRILLA.length; fila++) {
                StackPane celda = GRILLA[fila][columna].paint();
                gridPane.add(celda, fila, columna);
            }
        }
        return gridPane;
    }
}
