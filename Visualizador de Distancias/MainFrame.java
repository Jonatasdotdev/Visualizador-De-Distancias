import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainFrame extends JFrame {

    private List<Distancia> distancias;
    private JTextArea textArea;

    public MainFrame(String arquivo) {
        try {
            distancias = Utils.lerCidades(arquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        setTitle("Visualizador de Distâncias");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));

        JButton btnExibirTodas = new JButton("Exibir Todas");
        JButton btnOrdenar = new JButton("Ordenar");
        JButton btnMenor = new JButton("Menor Distância");
        JButton btnMaior = new JButton("Maior Distância");
        JButton btnSair = new JButton("Sair");

        btnExibirTodas.addActionListener(e -> exibirTodas());
        btnOrdenar.addActionListener(e -> ordenarDistancias());
        btnMenor.addActionListener(e -> exibirMenorDistancia());
        btnMaior.addActionListener(e -> exibirMaiorDistancia());
        btnSair.addActionListener(e -> System.exit(0));

        buttonPanel.add(btnExibirTodas);
        buttonPanel.add(btnOrdenar);
        buttonPanel.add(btnMenor);
        buttonPanel.add(btnMaior);
        buttonPanel.add(btnSair);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void exibirTodas() {
        textArea.setText(distancias.stream()
                .map(Distancia::toString)
                .collect(Collectors.joining("\n")));
    }

    private void ordenarDistancias() {
        textArea.setText(distancias.stream()
                .sorted()
                .map(Distancia::toString)
                .collect(Collectors.joining("\n")));
    }

    private void exibirMenorDistancia() {
        distancias.stream()
                .min(Comparator.naturalOrder())
                .ifPresent(distancia -> textArea.setText(distancia.toString()));
    }

    private void exibirMaiorDistancia() {
        distancias.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(distancia -> textArea.setText(distancia.toString()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame("cidades.csv");
            frame.setVisible(true);
        });
    }
}
