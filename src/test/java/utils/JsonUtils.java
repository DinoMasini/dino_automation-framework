package utils;
/*

getObjectMapper() | Crea un ObjectMapper configurato per ignorare errori di parsing
parseJsonFromHtmlBody(...) | Estrae manualmente il contenuto tra <body> e </body> e lo deserializza
 */

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public static <T> T parseJsonFromHtmlBody(String htmlBody, Class<T> clazz) {
        // Suppongo che il JSON sia contenuto tra <body> e </body>
        int start = htmlBody.indexOf("<body>") + "<body>".length();
        int end = htmlBody.indexOf("</body>");
        if (start < 0 || end < 0 || end <= start) {
            throw new IllegalArgumentException("Formato HTML non valido, impossibile estrarre JSON");
        }

        String json = htmlBody.substring(start, end).trim();

        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Errore nella deserializzazione JSON: " + e.getMessage());
        }
    }
}
