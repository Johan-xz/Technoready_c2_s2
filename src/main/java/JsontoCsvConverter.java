import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Map;

/**
 * the JsontoCsvConverter class is the bridge between the ReadJsonf class and writecsvf class
 * and consist about the following steps
 * 1. reads raw Json content from a file using readJsonFile method
 * 2. determines inf the root is a JSONArray structure or JSONObject structure
 * 3. flattens each JSON structure using Parse method of ParseJson class
 * 4. Stores the flattened data in a map structure for indexed access
 * 5.the parameters outputPath and flatArray to the method writeCsv from writecsvf class.
 *
 * @see ReadJsonf and method readJsonFile
 * @see ParseJson and the method parse
 * @see writecsvf and the method writeCsv
 * @see org.json.JSONObject
 * @see org.json.JSONArray
 */
public class JsontoCsvConverter {
    public static void convert(String inputPath, String outputPath) throws Exception {
        String rawJson = ReadJsonf.readJsonFile(inputPath);
        Object root = new JSONTokener(rawJson).nextValue();

        JSONArray flatArray = new JSONArray();

        if (root instanceof JSONArray arr) {
            for (int i = 0; i < arr.length(); i++) {
                Map<String, String> flatMap = ParseJson.parse(arr.get(i).toString());
                flatArray.put(new JSONObject(flatMap));
            }
        } else if (root instanceof JSONObject obj) {
            Map<String, String> flatMap = ParseJson.parse(obj.toString());
            flatArray.put(new JSONObject(flatMap));
        }

        writecsvf.writeCsv(outputPath, flatArray);
    }
}
