package objectdata;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class GeneralObject {
    protected void fromJsonToObject(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (is == null) {
                throw new RuntimeException("File not found: " + filePath);
            }
            objectMapper.readerForUpdating(this).readValue(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON: " + filePath, e);
        }
    }
}
