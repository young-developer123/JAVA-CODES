package Elijah;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class RegistrationTableForm extends JFrame implements ActionListener {
    JTextField idField, nameField, contactField;
    JRadioButton maleButton, femaleButton;
    JTextArea addressArea;
    JButton registerButton, exitButton;
    JTable table;
    DefaultTableModel model;
    ButtonGroup genderGroup;

    public RegistrationTableForm() {
        setTitle("Registration Form");
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 100, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(130, 30, 150, 30);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 70, 150, 30);
        add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 100, 30);
        add(genderLabel);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(130, 110, 70, 30);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(210, 110, 80, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        add(maleButton);
        add(femaleButton);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 150, 100, 30);
        add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setBounds(130, 150, 150, 60);
        add(addressArea);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(30, 220, 100, 30);
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(130, 220, 150, 30);
        add(contactField);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 270, 100, 30);
        registerButton.addActionListener(this);
        add(registerButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 270, 100, 30);
        exitButton.addActionListener(this);
        add(exitButton);

        // Table setup
        String[] columns = {"ID", "Name", "Gender", "Address", "Contact"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(320, 30, 350, 270);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String id = idField.getText();
            String name = nameField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Unspecified";
            String address = addressArea.getText();
            String contact = contactField.getText();

            if (id.isEmpty() || name.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
                return;
            }

            model.addRow(new Object[]{id, name, gender, address, contact});
            clearFields();
        } else if (e.getSource() == exitButton) {
            dispose();
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        genderGroup.clearSelection();
        addressArea.setText("");
        contactField.setText("");
    }

    public static void main(String[] args) {
        new RegistrationTableForm();
    }
}
