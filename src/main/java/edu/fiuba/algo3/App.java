package edu.fiuba.algo3;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.scenes.InicioScene;
import edu.fiuba.algo3.view.scenes.SceneUtil;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    private MediaPlayer mediaPlayer;    //para que el recolector de basura no lo borre y se siga reproduciendo

    @Override
    public void start(Stage stage) {

        configurarVentana(stage);

        AlgoRoma algoRoma = new AlgoRoma();
        InicioScene inicio = new InicioScene(stage, algoRoma);

        stage.setScene(inicio.getScene());
        stage.show();
    }

    private void configurarVentana(Stage stage) {
        stage.setTitle("AlgoRoma");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/equipamiento/casco.png")).toExternalForm());
        stage.getIcons().add(icon);
        double width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        SceneUtil.setDimensions(width, height);
        stage.setMaximized(true);
        stage.setResizable(false);
        reproducirSonido();
        //TODO: hacer que se reproduzca el sonido
    }

    private void reproducirSonido() {
        Media sonido = new Media(Objects.requireNonNull(getClass().getResource("/musica/Pufino-ThereBeDragons.mp3")).toExternalForm());
        mediaPlayer = new MediaPlayer(sonido);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch();
    }
}