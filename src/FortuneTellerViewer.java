import javax.swing.*;

public class FortuneTellerViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FortuneTellerFrame();
        });
    }
}
