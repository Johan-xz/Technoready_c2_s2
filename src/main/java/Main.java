import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        /**
         * In this project use the method of UIManager to initialize the graphical user interface(GUI) with the system's
         * native  look and feel using the library swing with the @link javax.swing.UIManager with the method
         * setLookAndFeel.
         *
         * the method and the library can change in future updates to use paths and a better GUI
         * @author: Johan Gloria
         * @version 1.0.1
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsontoCsvUI.launch();

    }
}