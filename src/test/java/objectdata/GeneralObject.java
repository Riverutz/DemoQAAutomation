package objectdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.io.IOException;
import java.io.InputStream;

public class GeneralObject {

    @SneakyThrows(IOException.class)
    protected void fromJsonToObject(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) {

            if (is == null) {
                throw new RuntimeException("File not found: " + filePath);
            }

            objectMapper.readerForUpdating(this).readValue(is);
        }
    }
}