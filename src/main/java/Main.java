

public class Main {
    public static void main(String[] args) {
        /** using this if we prevent unvalid paths, and files not founds exception
         * @param inputPath json file path
         * @param outputPath path to write csv file
         * @throws first if is to communicate the correct use of the cmd run
         * second if is to communicate that the input file is not a json file.
         * @throws an error if is a different file that the json type.
         * call JsontoCSVConverter.java and its method convert
         * @param inputPath
         * @param outputPath
         * @exception gives a message of exception to the user
         */
        if (args.length < 2 ){
            System.err.println("Usage: java Main <input.json> <output.csv>");
            return;
        }
        String inputPath=args[0];
        String outputPath=args[1];
        if (!inputPath.toLowerCase().endsWith(".json")) {
            System.err.println("Error: the input file must be a file with end .json");
            return;
        }
        try {
            JsontoCsvConverter.convert(inputPath,outputPath);
            System.out.println("transformacion completa");
        } catch (Exception e){
            System.err.println("Error en la transformacion:" + e.getMessage());
        }
    }
}