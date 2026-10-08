package com.quizapp;
import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // for MySQL 8+
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quizdb", 
                "*****", 
                "******"
        );
    }
}
