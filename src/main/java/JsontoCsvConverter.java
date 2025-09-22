import org.json.JSONArray;

/**
 * This class is the bridge between the read class and the write class.
 * making on this way is better to future integrations if I want more functionalities.
 * @see ReadJsonf
 * @see writecsvf
 */
public class JsontoCsvConverter {
    /**
     *
     * @param inputPath was established in the Main.java file
     * @param outputPath was established in the Main.java file
     * @throws Exception is to delegate the errors to Main
     */
    public static void  convert(String inputPath, String outputPath) throws Exception {
        JSONArray jsonArray = ReadJsonf.readJsonArray(inputPath);
        writecsvf.writeCsv(outputPath,jsonArray);
    }
}
