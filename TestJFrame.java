import javax.swing.*;

public class TestJFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test JFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JLabel("Hello from JFrame", SwingConstants.CENTER));
            frame.setSize(320, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
