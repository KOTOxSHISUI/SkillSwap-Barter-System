package com.skillswap.ui;

import com.skillswap.dao.UserDAO;
import com.skillswap.model.User;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public LoginForm() {
        setTitle("SkillSwap - Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Absolute layout

        // Load background image
        URL location = getClass().getClassLoader().getResource("images/login_page.jpg");
        if (location == null) {
            JOptionPane.showMessageDialog(this, "Background image not found!");
            return;
        }
        ImageIcon backgroundIcon = new ImageIcon(location);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 500, 400);

        // Email Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(160, 130, 80, 25);
        emailField = new JTextField();
        emailField.setBounds(230, 130, 180, 25);

        // Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(160, 170, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(230, 170, 180, 25);

        // Show Password
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(230, 200, 180, 20);
        showPasswordCheckBox.setOpaque(false);
        showPasswordCheckBox.setForeground(Color.WHITE);
        showPasswordCheckBox.addActionListener(e ->
                passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•'));

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(230, 230, 180, 30);
        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByEmailAndPassword(email, password);
            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new Dashboard(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Register Button
        JButton registerButton = new JButton("Go to Registration");
        registerButton.setBounds(230, 270, 180, 30);
        registerButton.addActionListener(e -> {
            dispose();
            new UserRegistrationForm();
        });

        // Add to Frame
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(showPasswordCheckBox);
        add(loginButton);
        add(registerButton);
        add(backgroundLabel);

        setVisible(true);
    }
}
