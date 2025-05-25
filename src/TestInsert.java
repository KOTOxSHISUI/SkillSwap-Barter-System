package com.skillswap.test;

import com.skillswap.dao.UserDAO;
import com.skillswap.model.User;

public class TestInsert {
    public static void main(String[] args) {
        // Create a sample user object
        User testUser = new User(
                0, // ID will be auto-generated
                "Alice", // Name
                "alice@example.com", // Email
                "Guitar", // Skill Offered
                "Piano", // Skill Needed
                "pass123", // Password
                "Weekends", // Availability
                "In-Person" // Exchange Method
        );

        // Create DAO and insert the user
        UserDAO dao = new UserDAO();
        boolean inserted = dao.insertUser(testUser);

        // Output result
        if (inserted) {
            System.out.println("✅ User inserted successfully.");
        } else {
            System.out.println("❌ Failed to insert user.");
        }
    }
}
