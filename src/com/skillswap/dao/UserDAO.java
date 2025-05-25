package com.skillswap.dao;

import com.skillswap.model.User;
import com.skillswap.util.DBConnection;

import java.sql.*;

public class UserDAO {

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (name, email, skill_offered, skill_needed, password, availability, exchange_method) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSkillOffered());
            stmt.setString(4, user.getSkillNeeded());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getAvailability());
            stmt.setString(7, user.getExchangeMethod());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("skill_offered"),
                        rs.getString("skill_needed"),
                        rs.getString("password"),
                        rs.getString("availability"),
                        rs.getString("exchange_method")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
