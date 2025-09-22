import org.json.JSONArray;
import org.json.JSONTokener;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonf {
    /**
     * This method is where reads the json file
     * @param filePath is used in JsontoCsvConverter and gave by the user in the Command prompt
     * @return the content by a parser (JSONTokener) for a safer convert
     * @throws Exception to delegate the errors to Main
     */
    public static JSONArray readJsonArray(String filePath) throws Exception{
        String content = new String((Files.readAllBytes(Paths.get(filePath))));
        return new JSONArray(new JSONTokener(content));
    }
}
