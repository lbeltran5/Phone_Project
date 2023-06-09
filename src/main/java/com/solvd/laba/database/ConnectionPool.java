package com.solvd.laba.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final int CON_POOL_SIZE = 5;
    private static final Properties properties = new Properties();
    private static final String userName;
    private static final String url;
    private static final String password;
    private final List<Connection> conPool = new ArrayList<>(CON_POOL_SIZE);
    private final List<Connection> activeConnections = new ArrayList<>();
    private ConnectionPool() {
        for (int i = 0; i < CON_POOL_SIZE; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            conPool.add(connection);
        }
    }
    private static ConnectionPool instance = null;
    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(f);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        url = properties.getProperty("db.url");
        userName = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }
    Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return conn;
    }
    public synchronized Connection retrieve() {
        Connection newConn = null;
        if (conPool.isEmpty()) {
            newConn = getConnection();
        } else {
            newConn = conPool.remove(conPool.size() - 1);
        }
        activeConnections.add(newConn);
        LOGGER.info("The connection was retrieved: " + newConn.toString());
        return newConn;
    }
    public synchronized void putback(Connection c) {
        if (c != null) {
            boolean removed = activeConnections.remove(c);
            if (removed) {
                conPool.add(c);
                LOGGER.info("Putting the connection back to Connection pool: " + c.toString());
            } else {
                LOGGER.warn("Connection is not in the Active Connections list: " + c.toString());
            }
        }
    }

}
