package com.solvd.laba.database;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String args[]){
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/phone";
        String USER = "root";
        String PASSWORD = "1993l";

        try {
            // Register the JDBC driver (optional for some drivers)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection is successful to the database: " + DB_URL);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
