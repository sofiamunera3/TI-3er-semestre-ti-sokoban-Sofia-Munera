package org.model;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LevelTest {

    @Test
    void loadFromFileTest_debeCargarNumeroDificultadYTableroConArchivoValido() throws Exception {
        Level level = new Level();
        Path archivoTemporal = Files.createTempFile("nivel-test", ".json");
        Files.writeString(archivoTemporal, """
                {
                  \"number\": 1,
                  \"difficulty\": \"BEGINNER\",
                  \"board\": {
                    \"broad\": 5,
                    \"height\": 5
                  }
                }
                """);

        level.loadFromFile(archivoTemporal.toString());

        assertEquals(1, level.getNumber());
        assertEquals("BEGINNER", level.getDifficulty());
        assertNotNull(level.getBoard());
    }

    @Test
    void loadFromFileTest_debeConservarEstadoInicialCuandoLaRutaEsInvalida() {
        Level level = new Level();

        level.loadFromFile("/ruta/inexistente/nivel.json");

        assertEquals(0, level.getNumber());
        assertEquals(null, level.getDifficulty());
        assertEquals(null, level.getBoard());
    }
}
