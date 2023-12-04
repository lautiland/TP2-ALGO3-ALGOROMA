package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JuegoParser {
    public DataClassTablero parsear(String path, String formato) throws IOException {
        try (Reader reader = new FileReader(path)) {
            if (formato.equals("json")) {
                return JSONReader.obtenerMapaDesdeJson(reader);
            } else {
                Logger.getInstance().error("Formato no soportado: " + formato);
            }
        } catch (IOException e) {
            Logger.getInstance().error("No se pudo abrir el archivo: " + e.getMessage());
            throw e;
        }
        return null;
    }
}
