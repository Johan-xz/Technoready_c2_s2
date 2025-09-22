import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testtowritecsvf {
    @Test
    public void testWriteCsv_createsValidCsvFile() throws Exception {
        JSONArray data = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("name", "Johan");
        obj.put("age", 30);
        data.put(obj);

        String outputPath = "src/test/resources/test_output.csv";
        writecsvf.writeCsv(outputPath, data);

        assertTrue(Files.exists(Paths.get(outputPath)));
        String content = Files.readString(Paths.get(outputPath));
        assertTrue(content.contains("name"));
        assertTrue(content.contains("Johan"));
    }
}
