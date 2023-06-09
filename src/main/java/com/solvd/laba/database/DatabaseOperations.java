package com.solvd.laba.database;

import java.sql.*;

public interface DatabaseOperations {
    ResultSet executeQuery(String query) throws SQLException;
    int executeUpdate(String query) throws SQLException;
}
