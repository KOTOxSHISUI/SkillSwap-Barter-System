package com.skillswap.ui;

import com.skillswap.dao.UserDAO;
import com.skillswap.model.User;

import javax.swing.*;
import java.awt.*;

public class UserRegistrationForm extends JFrame {

    private JTextField nameField, emailField, skillOfferedField, skillNeededField, availabilityField, exchangeMethodField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public UserRegistrationForm() {
        setTitle("SkillSwap - User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 10, 10));

        // Fields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Skill Offered:"));
        skillOfferedField = new JTextField();
        add(skillOfferedField);

        add(new JLabel("Skill Needed:"));
        skillNeededField = new JTextField();
        add(skillNeededField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Show Password:"));
        showPasswordCheckBox = new JCheckBox();
        add(showPasswordCheckBox);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });

        add(new JLabel("Availability (optional):"));
        availabilityField = new JTextField();
        add(availabilityField);

        add(new JLabel("Exchange Method (optional):"));
        exchangeMethodField = new JTextField();
        add(exchangeMethodField);

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Already have an account? Login");

        add(registerButton);
        add(loginButton);

        registerButton.addActionListener(e -> registerUser());

        loginButton.addActionListener(e -> {
            dispose(); // Close registration form
            new LoginForm(); // Open login form
        });

        getRootPane().setDefaultButton(registerButton);

        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String skillOffered = skillOfferedField.getText().trim();
        String skillNeeded = skillNeededField.getText().trim();
        String password = new String(passwordField.getPassword());
        String availability = availabilityField.getText().trim();
        String exchangeMethod = exchangeMethodField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || skillOffered.isEmpty() || skillNeeded.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields except availability and exchange method are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User(0, name, email, skillOffered, skillNeeded, password, availability, exchangeMethod);

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.insertUser(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "User registered successfully!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        skillOfferedField.setText("");
        skillNeededField.setText("");
        passwordField.setText("");
        availabilityField.setText("");
        exchangeMethodField.setText("");
        showPasswordCheckBox.setSelected(false);
        passwordField.setEchoChar('•');
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserRegistrationForm::new);
    }
}
