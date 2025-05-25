package com.skillswap.ui;

import com.skillswap.model.User;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard(User user) {
        setTitle("SkillSwap - Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getName() + "!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.NORTH);

        JTextArea userInfo = new JTextArea();
        userInfo.setEditable(false);
        userInfo.setText(
                "Name: " + user.getName() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Skill Offered: " + user.getSkillOffered() + "\n" +
                        "Skill Needed: " + user.getSkillNeeded() + "\n" +
                        "Availability: " + user.getAvailability() + "\n" +
                        "Exchange Method: " + user.getExchangeMethod()
        );

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        centerPanel.add(new JScrollPane(userInfo), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dispose(); // Close dashboard
            new LoginForm(); // Go back to login
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        bottomPanel.add(logoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
