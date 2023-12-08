package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonIniciarHandler;
import edu.fiuba.algo3.controller.BotonSalirHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InicioView extends View {
    private final Scene scene;
    private Button iniciar;
    private Button salida;
    private final Stage stage;
    AlgoRoma juego;

    public InicioView(Stage stage, AlgoRoma juego) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);
        this.stage = stage;
        this.juego = juego;

        configurarTitulo(layout);
        configurarBotones(layout);
        configurarBackground(layout, stage);

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void configurarTitulo(VBox layout) {

        Text titleText = new Text("AlgoRoma");
        VBox.setMargin(titleText, new Insets(0, 0, TITULO_MB, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream(TITULO_FONT), TITULO_FS);
        titleText.setFont(titleFont);
        titleText.setFill(Color.WHITE);

        layout.getChildren().add(titleText);
    }

    private void configurarBotones(VBox layout) {

        iniciar = new Button("Iniciar");
        configurarBoton(iniciar);

        salida = new Button("Salir");
        configurarBoton(salida);

        iniciar.setOnAction(new BotonIniciarHandler(stage, juego));
        salida.setOnAction(new BotonSalirHandler());

        layout.getChildren().addAll(iniciar, salida);
    }

    public Scene getScene() {
        return scene;
    }
}
