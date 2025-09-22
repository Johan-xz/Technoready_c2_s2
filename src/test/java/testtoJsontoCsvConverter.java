import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testtoJsontoCsvConverter {
    @Test
    public void testConvertJsonToCsv_endToEnd() throws Exception {
        String inputPath = "src/test/resources/sample.json";
        String outputPath = "src/test/resources/generated.csv";

        JsontoCsvConverter.convert(inputPath, outputPath);

        assertTrue(Files.exists(Paths.get(outputPath)));
        String content = Files.readString(Paths.get(outputPath));
        assertTrue(content.startsWith("name")); // encabezado esperado
    }
}
