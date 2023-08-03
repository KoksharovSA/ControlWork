package org.example.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDB {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/mans_friends";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Se656658+";
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet downloadData(String SQL){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void uploadData(String SQL){
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
