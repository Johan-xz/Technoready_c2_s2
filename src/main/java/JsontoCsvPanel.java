import javax.swing.*;
import java.awt.*;
import java.io.File;
public class JsontoCsvPanel extends JPanel {
    /**
     * the {@code JsontoCsvPanel} class makes in the GUI a descriptive button to initialize the process where:
     * 1. select the JSON file
     * 2. if input is approved then capture as inputResult
     * 3. select where to save the CSV file
     * 4. if the output is approved then capture the path
     * 5. try to pass the absolute paths to JsontoCsvConverter
     * 6. if catch an exception then make an error message.
     *
     *
     * @see JsontoCsvConverter
     * @see javax.swing.JButton
     * @see javax.swing.JFileChooser
     * @see javax.swing.JOptionPane
     */
    public JsontoCsvPanel(){
        setLayout(new BorderLayout());

        JButton convertButton = new JButton("Convert JSON to CSV");

        convertButton.addActionListener(e -> {
            JFileChooser inputChooser = new JFileChooser();
            inputChooser.setDialogTitle("Select JSON File");
            int inputResult = inputChooser.showOpenDialog(this);
            if (inputResult == JFileChooser.APPROVE_OPTION){
                File inputFile =inputChooser.getSelectedFile();
                JFileChooser outputChooser = new JFileChooser();
                outputChooser.setDialogTitle("Select where to save the CSV file");
                int outputResult = outputChooser.showSaveDialog(this);

                if (outputResult == JFileChooser.APPROVE_OPTION){
                    File outputFile = outputChooser.getSelectedFile();

                    try {
                        JsontoCsvConverter.convert(inputFile.getAbsolutePath(),outputFile.getAbsolutePath());
                        JOptionPane.showMessageDialog(this, "The conversion was successful");
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }

            }
        });
        add(convertButton, BorderLayout.CENTER);
    }
}
