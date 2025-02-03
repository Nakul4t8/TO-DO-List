package com.todo.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Database connected successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

