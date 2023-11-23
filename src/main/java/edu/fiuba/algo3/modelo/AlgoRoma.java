package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AlgoRoma {

    private TableroB tablero;
    private List<Gladiador> gladiadores;

    private int turnosJugados = 0;


    public void iniciarJuego() throws IOException {
        List<JsonObject> mapa = obtenerListaDatosDesdeJson("mapa.json");
        this.gladiadores = new ArrayList<>();

        gladiadores.add(new Gladiador("Pepe"));


        tablero = new TableroB(gladiadores, mapa);

    }

    public int jugar() {
        boolean sinGanadores = true;
        while (sinGanadores) {
            turnosJugados += 1;
            for (Gladiador gladiador: this.gladiadores) {
                gladiador.turnoEn(this.tablero);
            }

            if (turnosJugados == 30) {
                sinGanadores = false;
            }
        }
        return 0;
    }

    //posibel ejemplo de como leer el json
    public static List<JsonObject> obtenerListaDatosDesdeJson(String rutaArchivoJson) throws IOException {
        List<JsonObject> listaDatos = new ArrayList<>();

        // Lee el archivo JSON
        try (Reader reader = new FileReader(rutaArchivoJson)) {
            // Parsea el JSON a un objeto JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);

            // Accede a los elementos del JSON y agrega cada objeto a la lista
            if (jsonElement.isJsonArray()) {
                JsonArray jsonArray = jsonElement.getAsJsonArray();

                for (JsonElement elemento : jsonArray) {
                    if (elemento.isJsonObject()) {
                        JsonObject jsonObject = elemento.getAsJsonObject();
                        listaDatos.add(jsonObject);
                    }
                }
            }
        }

        return listaDatos;
    }

}
