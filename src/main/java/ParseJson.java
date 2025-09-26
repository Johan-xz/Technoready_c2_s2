import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Universal JSON parser that handles both JSONObject and JSONArray roots,
 * flattens nested structures, and preserves key order.
 */
public class ParseJson {

    /**
     * Parses and flattens any valid JSON structure.
     * @param jsonContent Raw JSON string.
     * @return Flattened map of key-paths to values.
     * @throws JSONException If the JSON is invalid or unsupported.
     */
    public static Map<String, String> parse(String jsonContent) throws JSONException {
        JSONTokener tokener = new JSONTokener(jsonContent);
        Object root = tokener.nextValue();

        if (root instanceof JSONObject obj) {
            return flatten(obj, "");
        } else if (root instanceof JSONArray arr) {
            return flatten(arr, "");
        } else {
            throw new JSONException("Unsupported JSON root type: " + root.getClass().getSimpleName());
        }
    }

    private static Map<String, String> flatten(Object json, String prefix) {
        Map<String, String> flatMap = new LinkedHashMap<>();

        if (json instanceof JSONObject obj) {
            for (String key : obj.keySet()) {
                Object value = obj.get(key);
                flatMap.putAll(flatten(value, prefix.isEmpty() ? key : prefix + "." + key));
            }
        } else if (json instanceof JSONArray arr) {
            for (int i = 0; i < arr.length(); i++) {
                Object value = arr.get(i);
                flatMap.putAll(flatten(value, prefix + "[" + i + "]"));
            }
        } else {
            flatMap.put(prefix, json == null ? "null" : json.toString());
        }

        return flatMap;
    }
}