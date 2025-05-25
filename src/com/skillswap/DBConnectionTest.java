package com.skillswap;

import com.skillswap.util.DBConnection;

import java.sql.Connection;

public class DBConnectionTest {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Database connection successful!");
        } else {
            System.out.println("❌ Database connection failed!");
        }
    }
}
