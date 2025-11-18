package Elijah;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {
    JTextField nameField, mobileField;
    JRadioButton maleButton, femaleButton;
    JComboBox<String> dayBox, monthBox, yearBox;
    JTextArea addressArea;
    JCheckBox termsBox;
    JButton submitButton, resetButton;
    ButtonGroup genderGroup;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 30);
        add(nameField);

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(30, 70, 100, 30);
        add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setBounds(150, 70, 200, 30);
        add(mobileField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 100, 30);
        add(genderLabel);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(150, 110, 70, 30);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(230, 110, 80, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        add(maleButton);
        add(femaleButton);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(30, 150, 100, 30);
        add(dobLabel);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        dayBox = new JComboBox<>(days);
        dayBox.setBounds(150, 150, 50, 30);
        add(dayBox);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(210, 150, 70, 30);
        add(monthBox);

        String[] years = new String[100];
        for (int i = 1925; i <= 2024; i++) years[i - 1925] = String.valueOf(i);
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(290, 150, 60, 30);
        add(yearBox);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 190, 100, 30);
        add(addressLabel);

        addressArea = new JTextArea();
        addressArea.setBounds(150, 190, 200, 60);
        add(addressArea);

        termsBox = new JCheckBox("Accept Terms And Conditions");
        termsBox.setBounds(30, 270, 250, 30);
        add(termsBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(80, 320, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 320, 100, 30);
        resetButton.addActionListener(this);
        add(resetButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (!termsBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please accept the terms and conditions.");
                return;
            }
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Unspecified";
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String info = "Name: " + nameField.getText() +
                          "\nMobile: " + mobileField.getText() +
                          "\nGender: " + gender +
                          "\nDOB: " + dob +
                          "\nAddress: " + addressArea.getText();
            JOptionPane.showMessageDialog(this, "Submitted:\n" + info);
        } else if (e.getSource() == resetButton) {
            nameField.setText("");
            mobileField.setText("");
            genderGroup.clearSelection();
            dayBox.setSelectedIndex(0);
            monthBox.setSelectedIndex(0);
            yearBox.setSelectedIndex(0);
            addressArea.setText("");
            termsBox.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
