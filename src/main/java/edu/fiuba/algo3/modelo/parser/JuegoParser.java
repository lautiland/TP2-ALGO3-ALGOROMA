package edu.fiuba.algo3.modelo.parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JuegoParser {
    public DataClassTablero parsear(String path, String formato) throws IOException {
        try (Reader reader = new FileReader(path)) {
            if (formato.equals("json")) {
                return JSONReader.obtenerMapaDesdeJson(reader);
            } else {
                System.out.println("Formato no soportado"); //TODO: Usar el logger a futuro aca
            }
        } catch (IOException e) {
            System.out.println("No se pudo abrir el archivo"); //TODO: Usar el logger a futuro aca
            e.printStackTrace(); //TODO: reemplazar logger.error(e.getMessage()) a futuro
            throw e;
        }
        return null;
    }
}
