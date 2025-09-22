import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testtoReadJsonf {
    @Test
    public void testReadJsonArray_validFile_returnsJSONArray() throws Exception {
        String path = "src/test/resources/sample.json";
        JSONArray result = ReadJsonf.readJsonArray(path);
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
