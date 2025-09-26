HI, this work is developed by Johan and is a project to Read Json files and transform it to CSV files.

The two libraries used in this project is org.json and opencsv using an interface of swing(probably is going to change in the future).

The converter consist in three java files, besides the main, that each one has their function on the project The titles could give an idea of what they do, the bridge between them is **"JsontoCsvConverter"** were the two java files interacts and the inputpath was gave by the Main.
# V 1.0
In this first version is a file to each one of the java files to prove them in an isolated environment to see if they work correctly.
# V 1.0.2
In version 1.0.2 is added a **Graphical User Interface (GUI)** so the users can manage the json files and the csv path and name more easily
without make use of, also I added a parser but is not completed yet, the library org.json hashes the JsonObjects so it´s
little difficult to manage the order of columns, but I'm working on it for the next version using the ordered keys and reorder in the "writecsvf" class.

The GUI is controlled by "JsontoCsvUI" and "JsontoCsvPanel" classes, but I'm thinking in change it to JavaFX because the actual GUI is better than the default 
of Swing but is not quite enough to keep me satisfied, so I'm going to look on other libraries to see if there's a better file explorer design.

## the actual Transformation Algorithm is:


1. The user selects a JSON file via the GUI (JsontoCsvPanel).
2. The file is read as a raw string using ReadJsonFile.readJsonFile(inputPath).
3. The raw JSON string is parsed using JSONTokener.
4. The root is dynamically detected as either:
5. - A JSONArray (multiple records)
6. - A JSONObject (single record)
7. Each JSON object is passed to ParseJson.parse(String) which:
8. Recursively traverses nested objects and arrays.
9. Constructs a flattened key-value map using LinkedHashMap<String, String> to preserve insertion order.
10. Keys are mapped using dot notation for objects (location.city) and bracket notation for arrays (preferences[0]).
11. The first flattened record is used to extract and preserve column order.
12. All subsequent records are aligned to this header structure.
13. Missing fields are filled with empty strings ("") to maintain row consistency.
14. The flattened records are converted to JSONObject instances and stored in a JSONArray.
15. The writecsvf.writeCSV(outputPath, JSONArray) method:
16. - Writes the header row using the ordered keys.
17. - Iterates through each record and writes aligned values.
18. - Uses OpenCSV to handle escaping, quoting, and formatting.
19. Input file existence and format are validated before parsing.
20. JSON parsing errors are caught and reported via JOptionPane.
21. Output file path is validated to ensure write permissions




