import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonf {
    /**
     * Using the library org.json with the objects JSONARRAY and JSONTOKENER
     * This method is where reads the json file ad pass it to the string "content"
     * @param filePath is used in JsontoCsvConverter and gave by the user in the GUI
     * @return the content to JsontoCsv converter and then to ParseJson class for a safer convert
     * @throws Exception to delegate the errors to Main
     */
    public static String readJsonFile(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
