import javax.swing.*;


public class JsontoCsvUI {
    /**
     * This class serves as the graphical entry point for the converter.
     * it initializes a Swing-based user interface, sets the native look and feel.
     * and sets the window properties like title, width, height and use JsontoCsvPanel to connect
     * with the other java classes.
     * @author Johan Gloria
     * @see javax.swing.JFrame
     * @see JsontoCsvPanel
     */
    public static void launch() {
        SwingUtilities.invokeLater(()-> {
            JFrame frame = new JFrame("JSON to Csv converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,200);
            frame.setLocationRelativeTo(null);
            frame.add(new JsontoCsvPanel());
            frame.setVisible(true);
        });
    }
}
