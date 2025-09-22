import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.Set;

public class writecsvf {
    /**
     * This class manage the convert of Json content to through the CSV writer
     * @param outputPath this is provided to us by the user in the Command prompt on the Main.
     * @param jsonArray this is provided to us by the ReadJsonf.java.
     * @throws Exception this delegates the errors to Main.
     */
    public static void writeCsv(String outputPath, JSONArray jsonArray) throws Exception{
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
            JSONObject firstObj = jsonArray.getJSONObject(0);
            Set<String> keys =firstObj.keySet();
            String[] headers = keys.toArray(new String[0]);
            writer.writeNext(headers);

            for (int i = 0; i < jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                String[] row = new String[headers.length];
                for (int j = 0; j < headers.length; j++){
                    row[j] = String.valueOf(obj.opt(headers[j]));
                }
                writer.writeNext(row);
            }
        }
    }
}
