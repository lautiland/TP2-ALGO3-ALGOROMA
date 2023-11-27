package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.excepciones.Ganador;
import edu.fiuba.algo3.modelo.excepciones.SinTurnos;
import edu.fiuba.algo3.modelo.observer.Observador;
import edu.fiuba.algo3.modelo.tablero.Tablero;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoRoma implements Observador {

    private Tablero tablero;
    private final List<Gladiador> gladiadores = new ArrayList<>();;
    private final Turnos turnos = new Turnos();


    public void iniciarJuegoCompleto() throws IOException {
        solicitarNombres();
        List<JsonObject> mapaCamino = obtenerListaCaminoDesdeJson("mapa.json");
        Object[] tamanio = obtenerTamanio("mapa.json");
        assert tamanio != null;
        this.tablero = new Tablero(gladiadores, mapaCamino, (Integer) tamanio[1], (Integer) tamanio[0]);
    }

    public void solicitarNombres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos jugadores?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int cant = 1; cant <= cantidad; cant++) {
            System.out.println("Ingrese el nombre del jugador " + cant + ": ");
            String nombre = scanner.nextLine();
            this.gladiadores.add(new Gladiador(nombre, this));
        }
    }

    public int jugar() {
        while (true) {
            try {
                this.turnos.ejecutar(this.gladiadores, this.tablero);
            } catch (Ganador | SinTurnos e) {
                break;
            }
        }
        return 0;
    }

    public static List<JsonObject> obtenerListaCaminoDesdeJson(String rutaArchivoJson) throws IOException {
        List<JsonObject> listaCamino = new ArrayList<>();

        try (Reader reader = new FileReader(rutaArchivoJson)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.has("camino")) {
                    JsonObject caminoObject = jsonObject.getAsJsonObject("camino");

                    if (caminoObject.has("celdas")) {
                        JsonArray celdasArray = caminoObject.getAsJsonArray("celdas");

                        for (JsonElement celdaElement : celdasArray) {
                            if (celdaElement.isJsonObject()) {
                                JsonObject celdaObject = celdaElement.getAsJsonObject();
                                listaCamino.add(celdaObject);
                            }
                        }
                    }
                }
            }
        }

        return listaCamino;
    }
    public static Object[] obtenerTamanio(String rutaArchivoJson) throws IOException {
        try (Reader reader = new FileReader(rutaArchivoJson)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.has("mapa")) {
                    JsonObject mapaObject = jsonObject.getAsJsonObject("mapa");

                    if (mapaObject.has("ancho") && mapaObject.has("largo")) {
                        int ancho = mapaObject.getAsJsonPrimitive("ancho").getAsInt();
                        int largo = mapaObject.getAsJsonPrimitive("largo").getAsInt();

                        return new Object[]{ancho, largo};
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void eliminarJugador(Gladiador g) {
        this.gladiadores.remove(g);
        this.tablero.eliminarPuntero(g);
        System.out.println(g.nombre + " Eliminado");
    }
}
