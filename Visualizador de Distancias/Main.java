import javax.swing.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MainFrame frame = new MainFrame("cidades.csv");
            
            frame.setVisible(true);
        });
    }
}
