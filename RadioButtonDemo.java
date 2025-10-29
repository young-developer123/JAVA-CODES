import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {
    private JLabel ImageLabel;
    private JRadioButton BirdButton, CatButton, DogButton, RabbitButton, PigButton;
    private ButtonGroup group;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        BirdButton = new JRadioButton("Bird");
        CatButton = new JRadioButton("Cat");
        DogButton = new JRadioButton("Dog");
        RabbitButton = new JRadioButton("Rabbit");
        PigButton = new JRadioButton("Pig");

        // Group them
        group = new ButtonGroup();
        group.add(BirdButton);
        group.add(CatButton);
        group.add(DogButton);
        group.add(RabbitButton);
        group.add(PigButton);

        // Add action listeners
        BirdButton.addActionListener(this);
        CatButton.addActionListener(this);
        DogButton.addActionListener(this);
        RabbitButton.addActionListener(this);
        PigButton.addActionListener(this);

        // Add buttons to frame
        add(BirdButton);
        add(CatButton);
        add(DogButton);
        add(RabbitButton);
        add(PigButton);

        // Default selection
        PigButton.setSelected(true);

        // Image label
        ImageLabel = new JLabel();
        updateImage("Pig");
        add(ImageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String selected = ((JRadioButton) e.getSource()).getText();
        updateImage(selected);
    }

    private void updateImage(String animal) {
        // Replace with actual image paths if available
        Image img = new ImageIcon(getClass().getResource("/images/" + animal.toLowerCase() + ".jpg")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageLabel.setIcon(new ImageIcon(img));

        ImageLabel.setText(animal); // fallback text
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo());
    }
}